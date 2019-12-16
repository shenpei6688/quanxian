package com.itheima.ssm.controller;


import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private IUserService userService;

    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        List<UserInfo> userlist =userService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList",userlist);
        modelAndView.setViewName("user-list");

        return modelAndView;


    }

    @RequestMapping("/save.do")
    public String saveDo(UserInfo userInfo)throws Exception{
        userService.insertDo(userInfo);
        return "redirect:findAll.do";
    }


    @RequestMapping("/findById.do")
    public ModelAndView findByIdDo(int id)throws Exception{
        UserInfo user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-show");
        return modelAndView;

    }


}

