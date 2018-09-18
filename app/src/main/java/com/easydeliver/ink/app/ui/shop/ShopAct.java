package com.easydeliver.ink.app.ui.shop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseActivity;

import me.jessyan.autosize.internal.CustomAdapt;

public class ShopAct extends BaseActivity implements CustomAdapt {

    private TabLayout tab_shop;

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.act_shop;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        tab_shop = contentView.findViewById(R.id.tab_shop);
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
