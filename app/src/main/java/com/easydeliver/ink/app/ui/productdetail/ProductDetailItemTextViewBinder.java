package com.easydeliver.ink.app.ui.productdetail;

import android.graphics.Color;
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

public class ProductDetailItemTextViewBinder extends ItemViewBinder<ProductDetailItemTextBean,
        ProductDetailItemTextViewBinder.ProductDetailItemTextViewHolder> {
    @NonNull
    @Override
    protected ProductDetailItemTextViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_productdetail_text, parent, false);
        return new ProductDetailItemTextViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProductDetailItemTextViewHolder holder, @NonNull ProductDetailItemTextBean item) {
        holder.tv_productdetail_title.setText(new SpanUtils()
                .appendLine(item.getTitle())
                .setFontSize(dip2px(holder,40))
                .setForegroundColor(Color.parseColor("#000000"))

                .appendLine(item.getDesc()).setForegroundColor(Color.parseColor("#a7a7a7"))
                .setFontSize(dip2px(holder,18))
                .appendLine("").setLineHeight(dip2px(holder,50))
                .append("$").setFontSize(dip2px(holder,40)).setForegroundColor(Color.parseColor("#FF4D4B"))
                .appendSpace(dip2px(holder,18))
                .append(item.getPrice()+"").setFontSize(dip2px(holder,40)).setForegroundColor(Color.parseColor("#FF4D4B"))
                .appendSpace(dip2px(holder,22))
                .append("原价:").setFontSize(dip2px(holder,22))
                .setForegroundColor(Color.parseColor("#A7A7A7")).appendSpace(dip2px(holder,18))
                .append(item.getYuanPrice()+"").setForegroundColor(Color.parseColor("#A7A7A7"))
                .setStrikethrough().setFontSize(dip2px(holder,22))
                .create());

        holder.tv_discount.setText(item.getDiscount());
        //
        holder.tv_productdetail_info.setText(new SpanUtils()
                .appendLine("库存："+item.getStock()).setForegroundColor(Color.parseColor("#A7A7A7"))
                .setFontSize(dip2px(holder,18))
                .appendLine("").setLineHeight(dip2px(holder,45))
                .appendLine(holder.itemView.getContext().getString(R.string.product_info))
                .setForegroundColor(Color.parseColor("#A7A7A7"))
                .appendLine("").setLineHeight(dip2px(holder,20))
                .appendLine(item.getProductInfo())
                .setForegroundColor(Color.parseColor("#222222"))
                .appendLine("").setLineHeight(dip2px(holder,40))
                .appendLine(holder.itemView.getContext().getString(R.string.product_postage_info))
                .setForegroundColor(Color.parseColor("#A7A7A7"))
                .appendLine("").setLineHeight(dip2px(holder,20))
                .appendLine(item.getProduct_postage_info()).setFontSize(dip2px(holder,40))
                .setForegroundColor(Color.parseColor("#222222"))
                .create());

    }

    private Integer dip2px(ProductDetailItemTextViewHolder holder,int dpValue){
        return ScreenUtils.dip2px(holder.itemView.getContext(), dpValue);
    }
    public class ProductDetailItemTextViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_productdetail_title;
        private TextView tv_discount;
        private TextView tv_productdetail_info;
        public ProductDetailItemTextViewHolder(View itemView) {
            super(itemView);
            tv_productdetail_title = itemView.findViewById(R.id.tv_productdetail_title);
            tv_discount = itemView.findViewById(R.id.tv_discount);
            tv_productdetail_info = itemView.findViewById(R.id.tv_productdetail_info);
        }
    }
}
