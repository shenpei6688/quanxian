package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleDao {
    @Select("select * from role")
    public List<Role> findAll();
    @Insert("insert into role (roleName,roleDesc)values(#{roleName},#{roleDesc})")
    public void save(Role role);
    @Select("select * from role where id in (select roleid from user_role where userid=#{userid})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id",javaType = java.util.List.class,many=@Many(select = "com.itheima.ssm.dao.IPermissionDao.findByroleid")),
    }
    )
    public List<Role> findByuserid(int userid);
}
