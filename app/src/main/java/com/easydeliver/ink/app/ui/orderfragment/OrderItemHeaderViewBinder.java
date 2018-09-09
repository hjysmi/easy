package com.easydeliver.ink.app.ui.orderfragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easydeliver.ink.app.R;
import com.facebook.drawee.view.SimpleDraweeView;

import me.drakeet.multitype.ItemViewBinder;

public class OrderItemHeaderViewBinder extends ItemViewBinder<OrderItemHeaderBean, OrderItemHeaderViewBinder.OrderItemViewHolder> {
    @NonNull
    @Override
    protected OrderItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_order_header,parent,false);
        return new OrderItemViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderItemViewHolder holder, @NonNull OrderItemHeaderBean item) {
//        ImageUtil.load(holder.product_img,item.getUrl());
        holder.order_shop_name.setText(item.getFendian());
        holder.order_trade_result.setText(item.getResult());
        /*holder.product_name.setText(item.getName());
        holder.order_tv_count.setText("x "+item.getCount());
        holder.order_tv_price.setText(new SpanUtils()
                .append("原价：$ "+item.getPrice()).setFontSize(ScreenUtils.dip2px(holder.product_img.getContext(),24))
                .appendSpace(ScreenUtils.dip2px(holder.product_img.getContext(),20))
                .append("$ "+item.getYuanPrice()).setStrikethrough().setForegroundColor(Color.parseColor("#4A4A4A"))
                .appendSpace(ScreenUtils.dip2px(holder.product_img.getContext(),8))
                .append("门店折扣 5折优惠").setForegroundColor(Color.parseColor("#FF4D4F"))
                .create());*/
     /*   holder.total_sum.setText(new SpanUtils()
                .append("共 ").setForegroundColor(Color.parseColor("#B4B4B4"))
                .append(item.getCount()+" ").setForegroundColor(Color.parseColor("#FF4D4F"))
                .append("件商品").setForegroundColor(Color.parseColor("#B4B4B4"))
                .append("合计：$"+item.getTotal()).setForegroundColor(Color.parseColor("#FF4D4F"))
                .append("(包含配送费("+item.getExpress_price()+")").setForegroundColor(Color.parseColor("#B4B4B4"))
        .create());*/

    }

    public class OrderItemViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView product_img;
        TextView order_tv_price;
        TextView product_name;
        TextView order_tv_count;
        TextView order_shop_name;
        TextView order_trade_result;
        TextView total_sum;
        public OrderItemViewHolder(View itemView) {
            super(itemView);
            /*product_img = itemView.findViewById(R.id.product_img);
            order_tv_price = itemView.findViewById(R.id.order_tv_price);
            product_name = itemView.findViewById(R.id.product_name);
            order_tv_count = itemView.findViewById(R.id.order_tv_count);*/
            order_shop_name = itemView.findViewById(R.id.order_shop_name);
            order_trade_result = itemView.findViewById(R.id.order_trade_result);
        //    total_sum = itemView.findViewById(R.id.total_sum);

        }
    }
}
