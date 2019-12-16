package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {
    @Select("Select * from traveller where id in (Select travellerId from order_traveller where orderId=#{ordersId} ) ")
    public List<Traveller> findByOrderId(String ordersId) throws Exception;
}
