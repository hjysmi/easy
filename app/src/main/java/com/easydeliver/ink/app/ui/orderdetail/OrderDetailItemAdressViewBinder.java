package com.easydeliver.ink.app.ui.orderdetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.util.SpanUtils;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.utils.ScreenUtils;

import me.drakeet.multitype.ItemViewBinder;

public class OrderDetailItemAdressViewBinder extends ItemViewBinder<OrderDetailItemAdressAndTimeBean, OrderDetailItemAdressViewBinder.OrderDetailItemAdressViewHolder> {
    @NonNull
    @Override
    protected OrderDetailItemAdressViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_orderdetail_adress_time, parent, false);
        viewItem.setTag(new OrderDetailItemAdressAndTimeBean());
        return new OrderDetailItemAdressViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderDetailItemAdressViewHolder holder, @NonNull OrderDetailItemAdressAndTimeBean item) {

        holder.img_address_time.setImageResource(item.getImg_res());
        holder.tv_receive_info_time.setText(item.getReceive_title());
        SpannableStringBuilder str;
        if (item.getReceive_title() == R.string.order_receive_time) {
            str = new SpanUtils()
                    .append(item.getReceiveTime())
                    .create();
        } else {
            str = new SpanUtils()
                    .append(item.getReceiveName())
                    .appendSpace(ScreenUtils.dip2px(holder.itemView.getContext(), 45))
                    .appendLine(item.getReceivePhone())
                    .append(item.getReceiveAdress())
                    .create();
        }
        holder.tv_info.setText(str);
    }

    public class OrderDetailItemAdressViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_info;
        private ImageView img_address_time;
        private TextView tv_receive_info_time;

        public OrderDetailItemAdressViewHolder(View itemView) {
            super(itemView);
            tv_info = itemView.findViewById(R.id.tv_info);
            img_address_time = itemView.findViewById(R.id.img_address_time);
            tv_receive_info_time = itemView.findViewById(R.id.tv_receive_info_time);

        }
    }
}
