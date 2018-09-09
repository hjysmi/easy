package com.easydeliver.ink.app.ui.orderfragment;

public class OrderItemHeaderBean {
    private String Url;
    private String name;
    private Integer count;
    private String result;
    private String fendian;
    private Double price;
    private Double yuanPrice;
    private Double total;
    private Double express_price;

    public OrderItemHeaderBean() {
    }

    public OrderItemHeaderBean(String url, String name, Integer count, String result,
                               String fendian, Double price, Double yuanPrice, Double total, Double express_price) {
        Url = url;
        this.name = name;
        this.count = count;
        this.result = result;
        this.fendian = fendian;
        this.price = price;
        this.yuanPrice = yuanPrice;
        this.total = total;
        this.express_price = express_price;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFendian() {
        return fendian;
    }

    public void setFendian(String fendian) {
        this.fendian = fendian;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getYuanPrice() {
        return yuanPrice;
    }

    public void setYuanPrice(Double yuanPrice) {
        this.yuanPrice = yuanPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getExpress_price() {
        return express_price;
    }

    public void setExpress_price(Double express_price) {
        this.express_price = express_price;
    }
}
