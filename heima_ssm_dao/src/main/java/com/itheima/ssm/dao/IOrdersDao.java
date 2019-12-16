package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IOrdersDao {

    @Delete({
            "<script>",
            "delete",
            "from orders",
            "where id in",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    public void deleteById(@Param("ids")  List<Integer> idlist)throws Exception;

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column="id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select ="com.itheima.ssm.dao.IProductDao.findById"))




    })
    public List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,property = "id",column="id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select ="com.itheima.ssm.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one=@One(select ="com.itheima.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,one=@One(select ="com.itheima.ssm.dao.ITravellerDao.findByOrderId")),

    })
    public Orders findById(int ordersId) throws Exception;


    @Insert("insert into orders (orderNum,orderTime,peopleCount, orderDesc, payType,orderStatus)values(#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus})")
    public void insertDo(Orders orders)throws Exception;






}
