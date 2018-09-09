package com.easydeliver.ink.app.ui.orderfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.utils.FragmentUtils;

public class OrderFragment extends BaseFragment
        implements FragmentUtils.OnBackClickListener {
    public static OrderFragment newInstance() {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    private Fragment[] mFragments = new Fragment[5];
    private int curIndex;
    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        if (savedInstanceState != null) {
            curIndex = savedInstanceState.getInt("curIndex");
        }
        TabLayout tabLayout = contentView.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayoutOrderOnTabSelectedListener());
        mFragments[0] = OrderAllFragment.newInstance();
        mFragments[1] = OrderWaitPurchaseFragment.newInstance();
        mFragments[2] = OrderWorkFragment.newInstance();
        mFragments[3] = OrderExpressFragment.newInstance();
        mFragments[4] = OrderCommentFragment.newInstance();
        FragmentUtils.add(getActivity().getSupportFragmentManager(), mFragments, R.id.fragment_order, curIndex);
    }



    @Override
    public void doBusiness() {

    }

    private void showCurrentFragment(int index) {
        FragmentUtils.showHide(curIndex = index, mFragments);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curIndex", curIndex);
    }
    @Override
    public void onWidgetClick(View view) {
        // tvAboutFragment.setText("");
        /*switch (view.getId()) {
            case R.id.btn_show_about_fragment:

                break;

        }*/
    }


    @Override
    public boolean onBackClick() {
//        FragmentUtils.popToFragment(getFragmentManager(), Demo1Fragment.class, true);
        return false;
    }


    private class TabLayoutOrderOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            showCurrentFragment(tab.getPosition());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }
}
