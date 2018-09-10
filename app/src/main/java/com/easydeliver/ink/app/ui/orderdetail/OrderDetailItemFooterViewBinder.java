package com.easydeliver.ink.app.ui.orderdetail;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.util.SpanUtils;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.ui.orderfragment.OrderItemFooterBean;

import me.drakeet.multitype.ItemViewBinder;

class OrderDetailItemFooterViewBinder extends ItemViewBinder<OrderItemFooterBean, OrderDetailItemFooterViewBinder.OrderDetailItemFooterViewHolder> {
    @NonNull
    @Override
    protected OrderDetailItemFooterViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_orderdetail_footer,parent,false);
        viewItem.setTag(new OrderItemFooterBean());
        return new OrderDetailItemFooterViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderDetailItemFooterViewHolder holder, @NonNull OrderItemFooterBean item) {
        holder.total_sum.setText(new SpanUtils()
                .append("共 ").setForegroundColor(Color.parseColor("#B4B4B4"))
                .append(item.getCount()+" ").setForegroundColor(Color.parseColor("#FF4D4F"))
                .append("件商品").setForegroundColor(Color.parseColor("#B4B4B4"))
                .append("合计：$"+item.getTotal()).setForegroundColor(Color.parseColor("#FF4D4F"))
                .append("(包含配送费("+item.getExpress_price()+")").setForegroundColor(Color.parseColor("#B4B4B4"))
                .create());
    }

    public class OrderDetailItemFooterViewHolder extends RecyclerView.ViewHolder {
        private TextView total_sum;
        public OrderDetailItemFooterViewHolder(View itemView) {
            super(itemView);
            total_sum = itemView.findViewById(R.id.total_sum);
        }
    }
}
