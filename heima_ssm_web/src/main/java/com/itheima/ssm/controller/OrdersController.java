package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOdersService OrdersService;
    /*查询全部订单-未分页
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
         List<Orders> ordersList = OrdersService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ordersList",ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;


    }

     查询全部订单-已分页*/

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,@RequestParam(name="size",required = true,defaultValue = "2") Integer size) throws Exception{
        List<Orders> ordersList = OrdersService.findAll(page,size);
        //pageinfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;


    }

    //查询订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findAll(@RequestParam(name="id",required = true) Integer ordersId) throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        Orders ordersbyId = OrdersService.findById(ordersId);
        modelAndView.addObject("orders",ordersbyId);
        modelAndView.setViewName("orders-show");
        return modelAndView;

    }

    @RequestMapping(value = "insert.do")
    @ResponseBody
    public void insertDo(@RequestBody Orders orders)throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        OrdersService.insertDo(orders);
        System.out.println("保存成功");
    }

   /* 删除订单*/
   @RequestMapping(value = "delete.do")
   @ResponseBody
   public String deleteDo(@RequestParam("ids[]") ArrayList<Integer> idlist)throws Exception{
       OrdersService.deletDo(idlist);
       return "redirect:findAll.do";

   }

}
