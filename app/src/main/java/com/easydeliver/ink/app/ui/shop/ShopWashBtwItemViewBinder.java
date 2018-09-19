package com.easydeliver.ink.app.ui.shop;

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

public class ShopWashBtwItemViewBinder extends ItemViewBinder<ShopWashBtwItemBean,
        ShopWashBtwItemViewBinder.ShopWashBtwItemViewHolder> {
    @NonNull
    @Override
    protected ShopWashBtwItemViewBinder.ShopWashBtwItemViewHolder onCreateViewHolder
            (@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_shopwash_btw,parent,false);
        itemView.setTag(new ShopWashBtwItemBean());
        return new ShopWashBtwItemViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull ShopWashBtwItemViewHolder holder, @NonNull ShopWashBtwItemBean item) {
        ImageUtil.load(holder.img_shopwash_btw,item.getUrl());
        holder.tv_shopwash_title.setText(new SpanUtils()
                .appendLine(item.getName()).setFontSize(ScreenUtils.dip2px(holder.itemView.getContext(),11))
                .setForegroundColor(Color.parseColor("#262626"))
                .append(item.getDesc()).setForegroundColor(Color.parseColor("#ABABAB"))
                .setFontSize(ScreenUtils.dip2px(holder.itemView.getContext(),8))
                .create());
        holder.tv_shopwash_price.setText("$ "+item.getPrice());

        holder.tv_shopwash_stock.setText("库存:"+item.getStock());


    }

    public class ShopWashBtwItemViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView img_shopwash_btw;
        private TextView tv_shopwash_title,tv_shopwash_price,tv_shopwash_stock;
        public ShopWashBtwItemViewHolder(View itemView) {
            super(itemView);
            img_shopwash_btw = itemView.findViewById(R.id.img_shopwash_btw);
            tv_shopwash_title = itemView.findViewById(R.id.tv_shopwash_title);
            tv_shopwash_price = itemView.findViewById(R.id.tv_shopwash_price);
            tv_shopwash_stock = itemView.findViewById(R.id.tv_shopwash_stock);
        }
    }
}
