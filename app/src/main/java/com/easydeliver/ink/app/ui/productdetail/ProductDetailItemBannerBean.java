package com.easydeliver.ink.app.ui.productdetail;

import com.easydeliver.ink.app.main.Banner;

import java.util.List;

public class ProductDetailItemBannerBean  {
    private List<Banner> banners;

    public ProductDetailItemBannerBean(List<Banner> banners) {
        this.banners = banners;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }
}
