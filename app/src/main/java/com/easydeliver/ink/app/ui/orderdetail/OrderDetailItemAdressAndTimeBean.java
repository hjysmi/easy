package com.easydeliver.ink.app.ui.orderdetail;

public class OrderDetailItemAdressAndTimeBean {
    private Integer img_res;
    private String receiveTime;
    private Integer receive_title;
    private String receiveName;
    private String receivePhone;
    private String receiveAdress;

    public OrderDetailItemAdressAndTimeBean() {
    }

    public OrderDetailItemAdressAndTimeBean(Integer img_res, String receiveTime, Integer receive_title, String receiveName, String receivePhone, String receiveAdress) {
        this.img_res = img_res;
        this.receiveTime = receiveTime;
        this.receive_title = receive_title;
        this.receiveName = receiveName;
        this.receivePhone = receivePhone;
        this.receiveAdress = receiveAdress;
    }

    public Integer getImg_res() {
        return img_res;
    }

    public void setImg_res(Integer img_res) {
        this.img_res = img_res;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getReceive_title() {
        return receive_title;
    }

    public void setReceive_title(Integer receive_title) {
        this.receive_title = receive_title;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAdress() {
        return receiveAdress;
    }

    public void setReceiveAdress(String receiveAdress) {
        this.receiveAdress = receiveAdress;
    }
}
