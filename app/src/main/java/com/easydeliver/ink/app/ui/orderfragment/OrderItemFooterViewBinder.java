package com.easydeliver.ink.app.ui.orderfragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.util.SpanUtils;
import com.easydeliver.ink.app.R;

import me.drakeet.multitype.ItemViewBinder;

public class OrderItemFooterViewBinder extends ItemViewBinder<OrderItemFooterBean, OrderItemFooterViewBinder.OrderItemFooterViewHolder> {
    @NonNull
    @Override
    protected OrderItemFooterViewBinder.OrderItemFooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_order_footer,parent,false);
        itemView.setTag(new OrderItemFooterBean());
        return new OrderItemFooterViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderItemFooterViewBinder.OrderItemFooterViewHolder holder, @NonNull OrderItemFooterBean item) {
        holder.total_sum.setText(new SpanUtils()
                .append("共 ").setForegroundColor(Color.parseColor("#B4B4B4"))
                .append(item.getCount()+" ").setForegroundColor(Color.parseColor("#FF4D4F"))
                .append("件商品").setForegroundColor(Color.parseColor("#B4B4B4"))
                .append("合计：$"+item.getTotal()).setForegroundColor(Color.parseColor("#FF4D4F"))
                .append("(包含配送费("+item.getExpress_price()+")").setForegroundColor(Color.parseColor("#B4B4B4"))
                .create());
    }

    public class OrderItemFooterViewHolder extends RecyclerView.ViewHolder {
        TextView total_sum;
        public OrderItemFooterViewHolder(View itemView) {
            super(itemView);
            total_sum = itemView.findViewById(R.id.total_sum);
        }
    }
}
