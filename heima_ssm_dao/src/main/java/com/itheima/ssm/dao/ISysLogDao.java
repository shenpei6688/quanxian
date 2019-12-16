package com.itheima.ssm.dao;

import com.itheima.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    @Select("select * from syslog")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "visitTime",column = "visitTime"),
            @Result(property = "username",column = "username"),
            @Result(property = "ip",column = "ip"),
            @Result(property = "url",column = "url"),
            @Result(property = "executionTime",column = "excutionTime"),
            @Result(property = "method",column = "method")
    })
    public List<SysLog> findAll() throws Exception;

    @Insert("insert into syslog (visitTime,username,ip,url,excutionTime,method)values (#{visitTime},#{username},#{ip}, #{url},#{executionTime},#{method})")
    public void save(SysLog sysLog)throws Exception;
}
