package com.easydeliver.ink.app.ui.shop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.common.util.SpanUtils;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseActivity;
import com.easydeliver.ink.app.base.utils.FragmentUtils;
import com.easydeliver.ink.app.base.utils.ScreenUtils;

import me.jessyan.autosize.internal.CustomAdapt;

public class ShopAct extends BaseActivity implements CustomAdapt {

    private TabLayout tab_shop;
    private Fragment[] mFragments = new Fragment[2];
    private int curIndex;
    private TextView tv_shopwash_totalprice;

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.act_shop;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        if (savedInstanceState != null) {
            curIndex = savedInstanceState.getInt("curIndex");
        }
        tab_shop = contentView.findViewById(R.id.tab_shop);
        tv_shopwash_totalprice = contentView.findViewById(R.id.tv_shopwash_totalprice);
        for(int i=0;i<2;i++)
        {
            TabLayout.Tab tab = tab_shop.newTab();
            tab.setCustomView(R.layout.item_shop_tab1);
            TextView tv = tab.getCustomView().findViewById(R.id.tv_shop_tab);
            ImageView img = tab.getCustomView().findViewById(R.id.img_shop_tab);
            if (i == 0) {
                tab.getCustomView().findViewById(R.id.tv_shop_tab).setSelected(true);//第一个tab被选中
                tab.getCustomView().findViewById(R.id.img_shop_tab).setSelected(true);
                tv.setText(R.string.main_wash);
                tv.setTextColor(getResources().getColor(R.color.basecolor));
                img.setBackgroundResource(R.drawable.xi);
            } else if (i == 1) {
                tab.getCustomView().findViewById(R.id.tv_shop_tab).setSelected(false);
                tv.setText(R.string.main_shop);
                tv.setTextColor(Color.parseColor("#BEBEBE"));
                img.setBackgroundResource(R.drawable.shop);
            }
            tab_shop.addTab(tab);
        }
        tab_shop.addOnTabSelectedListener(OnTabSelectedListener);

        mFragments[0] = ShopWashFragment.newInstance();
        mFragments[1] = ShopBtwFragment.newInstance();
        FragmentUtils.add(getSupportFragmentManager(), mFragments,
                R.id.fragment_shop, curIndex);

        tv_shopwash_totalprice.setText(new SpanUtils()
                .append(getResources().getString(R.string.shop_totalprice))
                .setFontSize(ScreenUtils.dip2px(this,11))
                .append(" $ ").setFontSize(ScreenUtils.dip2px(this,14))
                .append("36.00")
                .create());
    }

    TabLayout.OnTabSelectedListener OnTabSelectedListener = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            tab.getCustomView().findViewById(R.id.tv_shop_tab).setSelected(true);
            tab.getCustomView().findViewById(R.id.img_shop_tab).setSelected(true);
            TextView tv = tab.getCustomView().findViewById(R.id.tv_shop_tab);
            ImageView img = tab.getCustomView().findViewById(R.id.img_shop_tab);
            tv.setTextColor(getResources().getColor(R.color.basecolor));
            img.setBackgroundResource(R.drawable.xi);
            showCurrentFragment(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            TextView tv =  tab_shop.getTabAt(tab.getPosition()).
                    getCustomView().findViewById(R.id.tv_shop_tab);
            ImageView img =  tab_shop.getTabAt(tab.getPosition()).
                    getCustomView().findViewById(R.id.img_shop_tab);
            tv.setSelected(false);
            img.setSelected(false);
            tv.setTextColor(Color.parseColor("#BEBEBE"));
            img.setBackgroundResource(R.drawable.shop);
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
    private void showCurrentFragment(int index) {
        FragmentUtils.showHide(curIndex = index, mFragments);
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curIndex", curIndex);
    }
}
