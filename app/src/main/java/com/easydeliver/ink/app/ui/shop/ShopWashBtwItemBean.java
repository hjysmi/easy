package com.easydeliver.ink.app.ui.shop;

public class ShopWashBtwItemBean {

    private String name;
    private String desc;
    private Double price;
    private Integer stock;
    private Integer count;
    private String url;

    public ShopWashBtwItemBean() {
    }

    public ShopWashBtwItemBean(String name, String desc, Double price, Integer stock, Integer count, String url) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.stock = stock;
        this.count = count;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
