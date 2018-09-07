package com.easydeliver.ink.app.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.common.util.ImageUtil;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.utils.ScreenUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import me.drakeet.multitype.ItemViewBinder;

public class MainNewItemViewBinder extends ItemViewBinder<MainNew, MainNewItemViewBinder.MainNewViewHolder> {
    @NonNull
    @Override
    protected MainNewViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View viewItem = inflater.inflate(R.layout.item_main_new,parent,false);
        viewItem.setTag(new MainNew());
        return new MainNewViewHolder(viewItem);
    }

    @Override
    protected void onBindViewHolder(@NonNull final MainNewViewHolder holder, final @NonNull MainNew item) {
        ImageUtil.load(holder.main_new_img,item.getUri());
        holder.main_new_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScreenUtils.cancelAdaptScreen();
                Toast.makeText(view.getContext(), ""+ item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public class MainNewViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView main_new_img;
        public MainNewViewHolder(View itemView) {
            super(itemView);
            main_new_img = itemView.findViewById(R.id.main_new_img);
        }
    }
}
