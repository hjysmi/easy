package com.easydeliver.ink.app.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.utils.ScreenUtils;

import me.drakeet.multitype.ItemViewBinder;

public class MainMenuItemViewBinder extends ItemViewBinder<MainMenu, MainMenuItemViewBinder.MainMenuViewHolder> implements View.OnClickListener {
    @NonNull
    @Override
    protected MainMenuViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View ItemView = inflater.inflate(R.layout.item_main_menu,parent,false);

        return new MainMenuViewHolder(ItemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull MainMenuViewHolder holder, @NonNull MainMenu item) {
        holder.tv_main_wash.setOnClickListener(this);
        holder.tv_main_shop.setOnClickListener(this);
        holder.tv_main_agent.setOnClickListener(this);
        holder.tv_main_express.setOnClickListener(this);
        holder.tv_main_more.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        ScreenUtils.cancelAdaptScreen();
        Toast.makeText(view.getContext(), ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
        /*switch (view.getId()){
            case R.id.tv_main_wash:
        }*/
    }

    public class MainMenuViewHolder extends RecyclerView.ViewHolder {

        TextView tv_main_wash;
        TextView tv_main_shop;
        TextView tv_main_agent;
        TextView tv_main_express;
        TextView tv_main_more;
        public MainMenuViewHolder(View itemView) {
            super(itemView);
            tv_main_wash = itemView.findViewById(R.id.tv_main_wash);
            tv_main_shop = itemView.findViewById(R.id.tv_main_shop);
            tv_main_agent = itemView.findViewById(R.id.tv_main_agent);
            tv_main_express = itemView.findViewById(R.id.tv_main_express);
            tv_main_more = itemView.findViewById(R.id.tv_main_more);
        }
    }
}
