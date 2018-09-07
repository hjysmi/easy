package com.easydeliver.ink.app.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easydeliver.ink.app.R;

import me.drakeet.multitype.ItemViewBinder;

public class MainTitleItemViewBinder extends ItemViewBinder<MainTitle, MainTitleItemViewBinder.MainTitleViewHolder> {
    @NonNull
    @Override
    protected MainTitleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_main_text,parent,false);
        return new MainTitleViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull MainTitleViewHolder holder, @NonNull MainTitle item) {
        holder.main_title_txt.setText(item.getInt_txt());
    }

    public class MainTitleViewHolder extends RecyclerView.ViewHolder {
        private TextView main_title_txt;
        public MainTitleViewHolder(View itemView) {
            super(itemView);
            main_title_txt = itemView.findViewById(R.id.main_title_txt);
        }
    }
}
