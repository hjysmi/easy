package com.easydeliver.ink.app.ui.orderdetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.common.util.SpanUtils;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.utils.ScreenUtils;

import me.drakeet.multitype.ItemViewBinder;

public class OrderDetailItemOrderIdViewBinder extends ItemViewBinder<OrderDetailItemOrderIdBean, OrderDetailItemOrderIdViewBinder.OrderDetailItemOrderIdViewHolder> {
    @NonNull
    @Override
    protected OrderDetailItemOrderIdViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_orderdetail_orderdid, parent, false);
        viewItem.setTag(new OrderDetailItemOrderIdBean());
        return new OrderDetailItemOrderIdViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderDetailItemOrderIdViewHolder holder, @NonNull OrderDetailItemOrderIdBean item) {
        holder.tv_orderid.setText(new SpanUtils()
                .append(holder.itemView.getContext().getString(R.string.order_orderid))
                .appendSpace(ScreenUtils.dip2px(holder.itemView.getContext(),20))
                .appendLine(item.getOrderId())
                .append(holder.itemView.getContext().getString(R.string.order_create_time))
                .appendSpace(ScreenUtils.dip2px(holder.itemView.getContext(),20))
                .appendLine(item.getCreateTime())
                .append(holder.itemView.getContext().getString(R.string.order_pay_time))
                .appendSpace(ScreenUtils.dip2px(holder.itemView.getContext(),20))
                .appendLine(item.getPayTime())
                .append(holder.itemView.getContext().getString(R.string.order_express_time))
                .appendSpace(ScreenUtils.dip2px(holder.itemView.getContext(),20))
                .appendLine(item.getExpressTime())
                .append(holder.itemView.getContext().getString(R.string.order_strike_time))
                .appendSpace(ScreenUtils.dip2px(holder.itemView.getContext(),20))
                .append(item.getStrikeTime())
                .create());
    }

    public class OrderDetailItemOrderIdViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_orderid;
        public OrderDetailItemOrderIdViewHolder(View itemView) {
            super(itemView);
            tv_orderid = itemView.findViewById(R.id.tv_orderid);
        }
    }
}
