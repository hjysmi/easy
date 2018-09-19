package com.easydeliver.ink.app.ui.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;

import me.jessyan.autosize.internal.CustomAdapt;

public class ShopWashFragment extends BaseFragment implements CustomAdapt{
    CommonAdapter mAdapter;
    public static Fragment newInstance() {
        Bundle args = new Bundle();
        ShopWashFragment fragment = new ShopWashFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_shop_wash;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        TabLayout tab_shop_wash = contentView.findViewById(R.id.tab_shop_wash);


    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }


    @Override
    public boolean isBaseOnWidth() {
        return true;
    }

    @Override
    public float getSizeInDp() {
        return 360;
    }
}
