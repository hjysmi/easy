package com.easydeliver.ink.app.ui.orderfragment;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easydeliver.ink.app.R;

public class OrderIndexItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //int position = parent.getChildLayoutPosition(view);
        if (!((view.getTag() instanceof OrderItemProductBean)
                ||(view.getTag() instanceof OrderItemFooterBean)

        )) {
            outRect.top = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_dp);
        }

       /*if (!(view.getTag() instanceof MainNew)) {

        }*/
    }

}
