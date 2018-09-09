package com.easydeliver.ink.app.ui.orderfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.easydeliver.ink.app.base.BaseFragment;

/**
 * 待付款
 */
public class OrderWaitPurchaseFragment extends BaseFragment{

    public static OrderWaitPurchaseFragment newInstance() {
        Bundle args = new Bundle();
        OrderWaitPurchaseFragment fragment = new OrderWaitPurchaseFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return 0;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
