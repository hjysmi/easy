package com.easydeliver.ink.app.ui.orderfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;

/**
 * 作业中
 */
public class OrderWorkFragment extends BaseFragment{
    public static OrderWorkFragment newInstance() {
        Bundle args = new Bundle();
        OrderWorkFragment fragment = new OrderWorkFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_order_all;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
      /*  TextView tv = contentView.findViewById(R.id.tv);
        tv.setText(R.string.order_work);*/
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
