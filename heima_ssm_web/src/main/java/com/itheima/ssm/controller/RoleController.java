package com.itheima.ssm.controller;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAllDo() throws Exception {

        List<Role> rolelist = iRoleService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList",rolelist);
        modelAndView.setViewName("role-list");
        return modelAndView;

    }

    @RequestMapping("/save.do")
    public String saveDo(Role role) throws Exception {

        iRoleService.save(role);
        return " t:findAll.do";

    }

}
