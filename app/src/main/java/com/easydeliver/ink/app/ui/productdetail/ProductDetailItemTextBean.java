package com.easydeliver.ink.app.ui.productdetail;

public class ProductDetailItemTextBean {
    private String title;
    private String desc;
    private Double price;
    private Double yuanPrice;
    private String discount;
    private Integer stock;
    private String productInfo;
    private String product_postage_info;
    public ProductDetailItemTextBean() {
    }

    public ProductDetailItemTextBean(String title, String desc, Double price, Double yuanPrice, String discount, Integer stock, String productInfo, String product_postage_info) {
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.yuanPrice = yuanPrice;
        this.discount = discount;
        this.stock = stock;
        this.productInfo = productInfo;
        this.product_postage_info = product_postage_info;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProduct_postage_info() {
        return product_postage_info;
    }

    public void setProduct_postage_info(String product_postage_info) {
        this.product_postage_info = product_postage_info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Double getYuanPrice() {
        return yuanPrice;
    }

    public void setYuanPrice(Double yuanPrice) {
        this.yuanPrice = yuanPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
