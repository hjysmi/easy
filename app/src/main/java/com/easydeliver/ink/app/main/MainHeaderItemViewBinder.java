package com.easydeliver.ink.app.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.common.util.ImageUtil;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.banner.BannerAdapter;
import com.easydeliver.ink.app.base.banner.SmartViewPager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

public class MainHeaderItemViewBinder extends ItemViewBinder<MainHeader, MainHeaderItemViewBinder.BannerItemViewHolder> {
    @NonNull
    @Override
    protected BannerItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_header, parent, false);
        itemView.setTag(new MainHeader());
        return new BannerItemViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull BannerItemViewHolder holder, @NonNull MainHeader item) {
        holder.setBannerData(item.getBanner());
    }

    static class BannerItemViewHolder extends RecyclerView.ViewHolder {

        private MainBannerAdapter adapter;
        private SmartViewPager banner;
        TextView tv;
        public BannerItemViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            banner.setNeedCirculate(true);
            banner.setNeedAutoScroll(true);
            banner.setIndicatorGravity(Gravity.BOTTOM | Gravity.CENTER);
            banner.setIndicatorColor(ContextCompat.getColor(itemView.getContext(), R.color.theme_color_primary),
                    ContextCompat.getColor(itemView.getContext(), R.color.colorPrimary));
            int height = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.top_banner_height);
            ViewGroup.LayoutParams params = new RelativeLayout.LayoutParams(1080, 500);
            banner.setLayoutParams(params);
            adapter = new MainBannerAdapter(itemView.getContext());
        }

        private void setBannerData(List<Banner> data) {
            adapter.setData(data, true);
            banner.setAdapter(adapter);

        }
    }

    static class MainBannerAdapter extends BannerAdapter<Banner, SimpleDraweeView> {

        private Context context;

        public MainBannerAdapter(Context ctx) {
            context = ctx;
        }

        @Override
        protected int getLayoutId() {
            return INVALID_ID;
        }

        @Override
        protected SimpleDraweeView  getItemView() {
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
        protected void bindData(final SimpleDraweeView itemView, Banner item) {
           ImageUtil.load(itemView, item.getUrl());
        }
    }


}
