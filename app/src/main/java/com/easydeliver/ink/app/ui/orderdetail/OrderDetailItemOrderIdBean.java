package com.easydeliver.ink.app.ui.orderdetail;

public class OrderDetailItemOrderIdBean {

    private String orderId;
    private String createTime;
    private String payTime;
    private String expressTime;
    private String strikeTime;

    public OrderDetailItemOrderIdBean() {
    }

    public OrderDetailItemOrderIdBean(String orderId, String createTime, String payTime, String expressTime, String strikeTime) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.payTime = payTime;
        this.expressTime = expressTime;
        this.strikeTime = strikeTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getExpressTime() {
        return expressTime;
    }

    public void setExpressTime(String expressTime) {
        this.expressTime = expressTime;
    }

    public String getStrikeTime() {
        return strikeTime;
    }

    public void setStrikeTime(String strikeTime) {
        this.strikeTime = strikeTime;
    }
}
