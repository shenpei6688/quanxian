package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    //删除订单记录
    @Override
    public void deletDo(List<Integer> idlist) throws Exception {
        iOrdersDao.deleteById(idlist);

    }

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        /* 分页从第一页开始，每页显示5条数据*/
        PageHelper.startPage(page, size);
        List<Orders> ordersList = iOrdersDao.findAll();
        return ordersList;
    }

    @Override
    public Orders findById(int ordersId) throws Exception {
        Orders orderbyId = iOrdersDao.findById(ordersId);
        return orderbyId;

    }

    //插入订单记录
    @Override
    public void insertDo(Orders orders) throws Exception {
        iOrdersDao.insertDo(orders);
        System.out.println("haha");
    }
}

