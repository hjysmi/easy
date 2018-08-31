package com.easydeliver.ink.app.base.widget.adapter.binder;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.widget.adapter.BaseLoadFailedBinder;
import com.common.widget.adapter.BaseViewHolder;
import com.easydeliver.ink.app.R;


/**
 * Created by miserydx on 17/12/20.
 */

public class LoadFailedBinder extends BaseLoadFailedBinder<LoadFailedBinder.LoadFailedHolder> {

    private static final int NO_ID = -1;

    private int resId = NO_ID;

    private int stringId = NO_ID;

    public void setResId(@DrawableRes int resId) {
        this.resId = resId;
    }

    public void setStringId(@StringRes int stringId) {
        this.stringId = stringId;
    }

    @NonNull
    @Override
    protected LoadFailedHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.item_load_failed, parent, false);
        return new LoadFailedHolder(itemView);
    }

    @Override
    protected void onBindViewHolder(@NonNull LoadFailedHolder holder) {
        if (resId != NO_ID) {
            holder.ivLoadFailed.setImageResource(resId);
        }
        if (stringId != NO_ID) {
            holder.tvLoadFailed.setText(stringId);
        }
    }

    class LoadFailedHolder extends BaseViewHolder {


        ImageView ivLoadFailed;
        TextView tvLoadFailed;

        public LoadFailedHolder(View itemView) {
            super(itemView);
            ivLoadFailed = itemView.findViewById(R.id.iv_load_failed);
            tvLoadFailed = itemView.findViewById(R.id.tv_load_failed);
           // ButterKnife.bind(this, itemView);
        }
    }

}
