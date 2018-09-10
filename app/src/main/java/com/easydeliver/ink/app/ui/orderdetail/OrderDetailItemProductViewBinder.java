package com.easydeliver.ink.app.ui.orderdetail;

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
import com.easydeliver.ink.app.ui.orderfragment.OrderItemProductBean;
import com.facebook.drawee.view.SimpleDraweeView;

import me.drakeet.multitype.ItemViewBinder;

class OrderDetailItemProductViewBinder extends ItemViewBinder<OrderItemProductBean, OrderDetailItemProductViewBinder.OrderDetailItemProductViewHolder> {
    @NonNull
    @Override
    protected OrderDetailItemProductViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_orderdetail_product,parent,false);
        viewItem.setTag(new OrderItemProductBean());
        return new OrderDetailItemProductViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderDetailItemProductViewHolder holder, @NonNull OrderItemProductBean item) {
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
        //
        holder.tv_introduce.setText(new SpanUtils()
                .appendLine("商品价格")
                .appendLine("运费")
                .appendLine("门店优惠")
                .appendLine("资费说明")
                .appendLine("每件物品不同重量按每公斤距离长短，当你想加载布局时，可以使用下面其中一种方法")
                .create());
        //
        holder.tv_content.setText(new SpanUtils()
                .appendLine(item.getPrice()+"")
                .appendLine(item.getExpress_price()+"")
                .appendLine("-26.00")
                .appendLine("每件物品不同重量")
                .create());
    }

    public class OrderDetailItemProductViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView product_img;
        TextView order_tv_price;
        TextView product_name;
        TextView order_tv_count;
        TextView tv_introduce;
        TextView tv_content;
        public OrderDetailItemProductViewHolder(View itemView) {
            super(itemView);
            product_img = itemView.findViewById(R.id.product_img);
            order_tv_price = itemView.findViewById(R.id.order_tv_price);
            product_name = itemView.findViewById(R.id.product_name);
            order_tv_count = itemView.findViewById(R.id.order_tv_count);
            tv_introduce = itemView.findViewById(R.id.tv_introduce);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }
}
