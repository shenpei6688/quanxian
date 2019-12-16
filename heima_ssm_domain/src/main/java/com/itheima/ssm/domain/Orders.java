package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Orders {
    private Integer id;

    /**
     * 订单描述
     */
    private String orderDesc;
    /**
     *  订单编号 不为空且唯一
     */
    private String orderNum;
    /**
     * 订单状态 0-未支付  1-已支付
     */
    private Integer orderStatus;
    private String orderStatusStr;
    /**
     *  下单时间
     */
    private Date orderTime;
    private String orderTimeStr;
    /**
     * 支付类型 0-支付宝  1-微信  2-其它
     */
    private Integer payType;
    private String payTypeStr;
    /**
     *  出行人数
     */
    private Integer peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;

    public Orders() {
    }

    public Orders(Integer id, String orderDesc, String orderNum, Integer orderStatus, String orderStatusStr, Date orderTime, String orderTimeStr, Integer payType, String payTypeStr, Integer peopleCount, Product product, List<Traveller> travellers, Member member) {
        this.id = id;
        this.orderDesc = orderDesc;
        this.orderNum = orderNum;
        this.orderStatus = orderStatus;
        this.orderStatusStr = orderStatusStr;
        this.orderTime = orderTime;
        this.orderTimeStr = orderTimeStr;
        this.payType = payType;
        this.payTypeStr = payTypeStr;
        this.peopleCount = peopleCount;
        this.product = product;
        this.travellers = travellers;
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
        if(orderStatus==0){
            orderStatusStr="未支付";

        }else if(orderStatus==1){
            orderStatusStr="已支付";
        }else {
            orderStatusStr="其它";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }


    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            /*不可以加string，加上string相当于重新创建了一个新的局部变量*/
            orderTimeStr= DateUtils.date2String(orderTime, "yyyy-MM-dd HH:mm");
            System.out.println(orderTimeStr);
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        if(payType==0){
            payTypeStr="支付宝";
        }else if(payType==1) {
            payTypeStr = "微信";
        }else {
            payTypeStr = "其它";
        }

        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
