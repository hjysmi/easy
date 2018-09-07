package com.easydeliver.ink.app.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.common.util.ImageUtil;
import com.easydeliver.ink.app.R;
import com.facebook.drawee.view.SimpleDraweeView;

import me.drakeet.multitype.ItemViewBinder;

public class MainHotRecommandItemViewBinder extends ItemViewBinder<MainHotRecommand, MainHotRecommandItemViewBinder.MainHotRecommandViewHolder> {
    @NonNull
    @Override
    protected MainHotRecommandViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
       View viewItem = inflater.inflate(R.layout.item_main_hotrecommand,parent,false);

        return new MainHotRecommandViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull MainHotRecommandViewHolder holder, final @NonNull MainHotRecommand item) {
        ImageUtil.load(holder.main_hotrecommand_img,item.getUrl());
        holder.main_hotrecommand_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ""+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class MainHotRecommandViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView main_hotrecommand_img;
        public MainHotRecommandViewHolder(View itemView) {
            super(itemView);
            main_hotrecommand_img = itemView.findViewById(R.id.main_hotrecommand_img);
        }
    }
}
