package com.easydeliver.ink.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.utils.FragmentUtils;

public class MeFragment extends BaseFragment
        implements FragmentUtils.OnBackClickListener {


    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        TextView tv = contentView.findViewById(R.id.tvText);
        tv.setText("Me");
    }

    @Override
    public void doBusiness() {

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
}
