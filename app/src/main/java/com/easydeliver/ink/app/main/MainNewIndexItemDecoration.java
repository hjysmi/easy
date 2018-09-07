package com.easydeliver.ink.app.main;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easydeliver.ink.app.R;

/**
 * Created by miserydx on 17/7/6.
 */

public class MainNewIndexItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildLayoutPosition(view);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = ((GridLayoutManager) parent.getLayoutManager()).getSpanSizeLookup();
        if (spanSizeLookup.getSpanSize(position) == 2) {
            if ((view.getTag() instanceof MainNew)) {
               // outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                //outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_new_dp);
                outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_new_dp);
            }
        } else {
            int spanIndex = spanSizeLookup.getSpanIndex(position, 2);
            switch (spanIndex) {
                case 0:
                    outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.padding_left_dp);
                    outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_new_dp);
                    outRect.bottom = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_dp);
                    break;
                case 1:
                    outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_new_dp);
                    outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.padding_left_dp);
                    outRect.bottom = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_dp);
                    break;
            }
        }
       /* if (!(view.getTag() instanceof MainNew)) {
            outRect.top = view.getContext().getResources().getDimensionPixelSize(R.dimen.divider_new_dp);
        }*/
    }
}