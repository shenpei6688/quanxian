package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private IUserDao UserDao;
    @Override
    public List<UserInfo> findAll() throws Exception {
        List<UserInfo> userlist = UserDao.findAll();
        return userlist;
    }

    @Override
    public void insertDo(UserInfo userInfo)throws Exception {
        System.out.println(userInfo.getPassword());
        String encode = bCryptPasswordEncoder.encode(userInfo.getPassword());
        System.out.println(encode);
        userInfo.setPassword(encode);
        UserDao.insertDo(userInfo);


    }
   //查询用户详情，展示用户的角色多，用户的权限
    @Override
    public UserInfo findById(int id) throws Exception {
        UserInfo  user= UserDao.findById(id);
        return user;

    }

//把数据库的属性验证，用户名和密码匹配就登录，登录之后权限不是ADMIN？USER不能访问其他菜单，权限满足才可以访问其他菜单
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo =UserDao.findByUsername(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true,getAuthority(userInfo.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles){
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

}
