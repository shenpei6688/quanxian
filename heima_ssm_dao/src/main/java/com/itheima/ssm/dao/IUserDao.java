package com.itheima.ssm.dao;

import com.itheima.ssm.domain.UserInfo;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select * from users")
    List<UserInfo> findAll()throws Exception;

    @Insert("insert into users (email,username,password,phonenum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void insertDo(UserInfo userInfo)throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roleName",column = "rolename"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phonenum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itheima.ssm.dao.IRoleDao.findByuserid"))
    })
    public UserInfo findById(int id) throws  Exception;

    @Select("select * from users where username=#{username}")
    @Results({
        @Result(property = "id",column = "id"),
        @Result(property = "roleName",column = "rolename"),
        @Result(property = "username",column = "username"),
        @Result(property = "password",column = "password"),
        @Result(property = "phoneNum",column = "phonenum"),
        @Result(property = "status",column = "status"),
        @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.itheima.ssm.dao.IRoleDao.findByuserid"))
    })
   public  UserInfo findByUsername(String username)throws Exception;
}
