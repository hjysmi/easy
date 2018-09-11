package com.easydeliver.ink.app.ui.productdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.common.util.ImageUtil;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.banner.BannerAdapter;
import com.easydeliver.ink.app.base.banner.SmartViewPager;
import com.easydeliver.ink.app.main.Banner;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

class ProductDetailItemBannerViewBinder extends ItemViewBinder<ProductDetailItemBannerBean,
        ProductDetailItemBannerViewBinder.ProductDetailItemBannerViewHolder> {
    @NonNull
    @Override
    protected ProductDetailItemBannerViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_productdetail_banner, parent, false);
        return new ProductDetailItemBannerViewHolder(viewItem);

    }

    @Override
    protected void onBindViewHolder(@NonNull ProductDetailItemBannerViewHolder holder, @NonNull ProductDetailItemBannerBean item) {
        holder.setBannerData(item.getBanners());
    }


    public class ProductDetailItemBannerViewHolder extends RecyclerView.ViewHolder {
        private SmartViewPager banner;
        private ProductDetailBannerAdapter adapter;

        public ProductDetailItemBannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            banner.setNeedCirculate(true);
            banner.setNeedAutoScroll(true);
            banner.setIndicatorGravity(Gravity.BOTTOM | Gravity.CENTER);
            banner.setIndicatorColor(ContextCompat.getColor(itemView.getContext(), R.color.theme_color_primary),
                    ContextCompat.getColor(itemView.getContext(), R.color.colorPrimary));
            adapter = new ProductDetailBannerAdapter(itemView.getContext());
        }

        private void setBannerData(List<Banner> data) {
            adapter.setData(data, true);
            banner.setAdapter(adapter);

        }
    }

    private class ProductDetailBannerAdapter extends BannerAdapter<Banner, SimpleDraweeView> {
        private Context context;

        public ProductDetailBannerAdapter(Context context) {
            this.context = context;
        }

        @Override
        protected int getLayoutId() {
            return INVALID_ID;
        }

        @Override
        protected SimpleDraweeView getItemView() {
            SimpleDraweeView imageView = new SimpleDraweeView(context);
            GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(imageView.getContext().getResources())
                    .setRoundingParams(RoundingParams.fromCornersRadius(5))
                    .build();
            imageView.setHierarchy(hierarchy);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            return imageView;
        }

        @Override
        protected void bindData(SimpleDraweeView itemView, Banner item) {
            ImageUtil.load(itemView, item.getUrl());
        }
    }
}
