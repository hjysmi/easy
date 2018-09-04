package com.easydeliver.ink.app.ui.mefragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.ui.IconFontTextView;

import me.drakeet.multitype.ItemViewBinder;

public class MeHeaderItemViewBinder extends ItemViewBinder<MeHeader, MeHeaderItemViewBinder.MeHeaderViewHolder> {


    @NonNull
    @Override
    protected MeHeaderViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_me_header,parent,false);
        return new MeHeaderViewHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull MeHeaderViewHolder holder, @NonNull MeHeader item) {

    }

    public class MeHeaderViewHolder extends RecyclerView.ViewHolder {
        private IconFontTextView tv_msg;
        public MeHeaderViewHolder(View itemView) {
            super(itemView);
            tv_msg = itemView.findViewById(R.id.tv_msg);
            tv_msg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("xue","click 消息中心");
                }
            });
        }
    }
}
