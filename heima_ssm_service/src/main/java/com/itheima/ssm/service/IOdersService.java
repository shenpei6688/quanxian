package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;


import java.util.List;

public interface IOdersService {

   void deletDo(List<Integer> idlist)throws Exception;

   List<Orders> findAll(int page, int  size) throws  Exception;
   Orders findById(int ordersId)throws Exception;
   void insertDo(Orders orders)throws Exception;

}
