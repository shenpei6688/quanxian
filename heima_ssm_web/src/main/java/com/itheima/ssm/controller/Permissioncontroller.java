package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermission;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/permission")
public class Permissioncontroller {

    @Autowired
    private IPermission iPermission;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        List<Permission> permissionlist = iPermission.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permissionList",permissionlist);
        modelAndView.setViewName("permission-list");
        return modelAndView;


    }

    @RequestMapping("/save.do")
    public String saveDo(Permission permission)throws Exception{
        iPermission.save(permission);
        return "redirect:findAll.do";

    }

}
