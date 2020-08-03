package com.xy.cola.test.example.co;

import com.xy.cola.dto.ClientObject;

import java.math.BigDecimal;

/**
 * 〈功能介绍〉<br>
 * <p>
 * 〈订单客户端对象〉
 *
 * @author xingyi on 2020/8/3.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderCO extends ClientObject {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 支付金额
     */
    private BigDecimal payment;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "OrderCO{" +
                "orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", orderStatus=" + orderStatus +
                ", payment=" + payment +
                ", extValues=" + extValues +
                '}';
    }
}
