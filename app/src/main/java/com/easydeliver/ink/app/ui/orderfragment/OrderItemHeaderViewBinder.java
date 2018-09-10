package com.easydeliver.ink.app.ui.orderfragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.ui.orderdetail.OrderDetailActivity;

import me.drakeet.multitype.ItemViewBinder;

public class OrderItemHeaderViewBinder extends ItemViewBinder<OrderItemHeaderBean, OrderItemHeaderViewBinder.OrderItemViewHolder> {
    @NonNull
    @Override
    protected OrderItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_order_header,parent,false);
        return new OrderItemViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull final OrderItemViewHolder holder, @NonNull OrderItemHeaderBean item) {
        holder.order_shop_name.setText(item.getFendian());
        holder.order_trade_result.setText(item.getResult());
        holder.ll_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),OrderDetailActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    public class OrderItemViewHolder extends RecyclerView.ViewHolder {
        TextView order_shop_name;
        TextView order_trade_result;
        LinearLayout ll_order;
        public OrderItemViewHolder(View itemView) {
            super(itemView);
            ll_order = itemView.findViewById(R.id.ll_order);
            order_shop_name = itemView.findViewById(R.id.order_shop_name);
            order_trade_result = itemView.findViewById(R.id.order_trade_result);
        }
    }
}
