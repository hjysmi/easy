package com.easydeliver.ink.app;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.easydeliver.ink.app.base.BaseActivity;
import com.easydeliver.ink.app.base.ui.widget.bottombar.BottomBar;
import com.easydeliver.ink.app.base.ui.widget.bottombar.CustomTabEntity;
import com.easydeliver.ink.app.base.ui.widget.bottombar.TabEntity;
import com.easydeliver.ink.app.base.utils.FragmentUtils;
import com.easydeliver.ink.app.main.MainFragment;
import com.easydeliver.ink.app.ui.mefragment.MeFragment;
import com.easydeliver.ink.app.ui.orderfragment.OrderFragment;

import java.util.ArrayList;


public class MainActivity extends BaseActivity{


    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles;
    private int[] mIconSelectIds = {
            R.drawable.homeed, R.drawable.ordered,
            R.drawable.meed};
    private int[] mIconUnselectIds = {
            R.drawable.home, R.drawable.order,
            R.drawable.me};

   // private BottomNavigationView navigation;
    private Fragment[] mFragments = new Fragment[3];
    private int curIndex;
    private BottomBar mBottomBar;

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        if (savedInstanceState != null) {
            curIndex = savedInstanceState.getInt("curIndex");
        }
        mBottomBar = findViewById(R.id.entrance_bar);
        mFragments[0] = MainFragment.newInstance();
        mFragments[1] = OrderFragment.newInstance();
        mFragments[2] = MeFragment.newInstance();
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.fragment_container, curIndex);
        mTitles = getResources().getStringArray(R.array.bottom_main_sections);
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mBottomBar.setTabEntities(mTabEntities);
        mBottomBar.setOnTabSelectedListener(new OnTabSelectedListener());

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    private void showCurrentFragment(int index) {
        FragmentUtils.showHide(curIndex = index, mFragments);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("curIndex", curIndex);
    }

    private class OnTabSelectedListener implements BottomBar.OnTabSelectedListener {
        @Override
        public void onTabSelected(int position, int prePosition) {
            showCurrentFragment(position);
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    }
}
