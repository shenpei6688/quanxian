package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 产品信息
 */
public class Product {
    /**
     * 出发城市
     */
    private String cityName;
    /**
     * 出发时间-由于页面提交的数据睡string类型，所以要加这个注释吧string转换为日期类型
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 名称
     */
    private String productName;
    /**
     * 编号 唯一
     */
    private String productNum;
    private double productPrice; // 产品价格
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public Product() {
    }

    public Product(String cityName, Date departureTime, String departureTimeStr, Integer id, String productDesc, String productName, String productNum, double productPrice, Integer productStatus, String productStatusStr) {
        this.cityName = cityName;
        this.departureTime = departureTime;
        this.departureTimeStr = departureTimeStr;
        this.id = id;
        this.productDesc = productDesc;
        this.productName = productName;
        this.productNum = productNum;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productStatusStr = productStatusStr;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if (departureTime != null) {
            departureTimeStr = DateUtils.date2String(departureTime, "yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if (productStatus != null) {
            // 状态 0 关闭 1 开启
            if (productStatus == 0) {
                productStatusStr = "关闭";
            }
            if (productStatus == 1) {
                productStatusStr = "开启";

            }
        }
            return productStatusStr;

    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
