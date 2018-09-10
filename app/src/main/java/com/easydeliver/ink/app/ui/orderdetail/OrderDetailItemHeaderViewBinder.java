package com.easydeliver.ink.app.ui.orderdetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.ui.orderfragment.OrderItemHeaderBean;

import me.drakeet.multitype.ItemViewBinder;

class OrderDetailItemHeaderViewBinder extends ItemViewBinder<OrderItemHeaderBean, OrderDetailItemHeaderViewBinder.OrderDetailItemHeaderViewHolder> {
    @NonNull
    @Override
    protected OrderDetailItemHeaderViewBinder.OrderDetailItemHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_orderdetail_header,parent,false);

        return new OrderDetailItemHeaderViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull final OrderDetailItemHeaderViewHolder holder, @NonNull final OrderItemHeaderBean item) {
        holder.order_shop_name.setText(item.getFendian());
        holder.order_trade_result.setText(item.getResult());
        holder.ll_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent intent = new Intent(holder.itemView.getContext(),OrderDetailActivity.class);
                holder.itemView.getContext().startActivity(intent);*/
                Toast.makeText(holder.itemView.getContext(), ""+item.getFendian(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class OrderDetailItemHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView order_shop_name;
        TextView order_trade_result;
        LinearLayout ll_order;
        public OrderDetailItemHeaderViewHolder(View itemView) {
            super(itemView);
            ll_order = itemView.findViewById(R.id.ll_order);
            order_shop_name = itemView.findViewById(R.id.order_shop_name);
            order_trade_result = itemView.findViewById(R.id.order_trade_result);
        }
    }
}
