package com.itheima.ssm.service;


import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermission {
    public List<Permission> findAll()throws Exception;
    public void save(Permission permission)throws Exception;

}
