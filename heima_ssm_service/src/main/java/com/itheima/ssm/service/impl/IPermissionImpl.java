package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class IPermissionImpl implements IPermission {
    @Autowired
    private IPermissionDao iPermissionDao;


    @Override
    public List<Permission> findAll() throws Exception{
        List<Permission> Permissionlist = iPermissionDao.findAll();
        return Permissionlist ;
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);

    }
}
