package com.easydeliver.ink.app.ui.orderfragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.util.ImageUtil;
import com.common.util.SpanUtils;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.utils.ScreenUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import me.drakeet.multitype.ItemViewBinder;

class OrderItemProductViewBinder extends ItemViewBinder<OrderItemProductBean, OrderItemProductViewBinder.OrderItemProductViewHolder> {
    @NonNull
    @Override
    protected OrderItemProductViewBinder.OrderItemProductViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_order_product,parent,false);
        itemView.setTag(new OrderItemProductBean());
        return new OrderItemProductViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderItemProductViewBinder.OrderItemProductViewHolder holder, @NonNull OrderItemProductBean item) {
        ImageUtil.load(holder.product_img,item.getUrl());
        holder.product_name.setText(item.getName());
        holder.order_tv_count.setText("x "+item.getCount());
        holder.order_tv_price.setText(new SpanUtils()
                .append("原价：$ "+item.getPrice()).setFontSize(ScreenUtils.dip2px(holder.product_img.getContext(),24))
                .appendSpace(ScreenUtils.dip2px(holder.product_img.getContext(),20))
                .append("$ "+item.getYuanPrice()).setStrikethrough().setForegroundColor(Color.parseColor("#4A4A4A"))
                .appendSpace(ScreenUtils.dip2px(holder.product_img.getContext(),8))
                .append("门店折扣 5折优惠").setForegroundColor(Color.parseColor("#FF4D4F"))
                .create());
    }

    public class OrderItemProductViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView product_img;
        TextView order_tv_price;
        TextView product_name;
        TextView order_tv_count;
        public OrderItemProductViewHolder(View itemView) {
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            order_tv_price = itemView.findViewById(R.id.order_tv_price);
            product_name = itemView.findViewById(R.id.product_name);
            order_tv_count = itemView.findViewById(R.id.order_tv_count);
        }
    }
}
