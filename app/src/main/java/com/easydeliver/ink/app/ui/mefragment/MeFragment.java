package com.easydeliver.ink.app.ui.mefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.common.statusbar.StatusBarCompat;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.utils.FragmentUtils;
import com.easydeliver.ink.app.base.utils.ScreenUtils;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;

import me.drakeet.multitype.Items;

public class MeFragment extends BaseFragment
        implements FragmentUtils.OnBackClickListener {

    private RecyclerView rv;
    private CommonAdapter mAdapter;

    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {
        if (ScreenUtils.isPortrait()) {
            //ScreenUtils.adaptScreen4VerticalSlide(this.getActivity(), 750);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_me;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        StatusBarCompat.translucentStatusBar(getActivity(), true);
        rv = contentView.findViewById(R.id.rv);
        LinearLayoutManager ll = new LinearLayoutManager(this.getActivity());
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(ll);
        mAdapter = new CommonAdapter();
        //header
        mAdapter.register(MeHeader.class, new MeHeaderItemViewBinder());
        mAdapter.register(MeText.class, new MeTextItemViewBinder());
        mAdapter.setScrollSaveStrategyEnabled(true);
        rv.setAdapter(mAdapter);
        Items item = new Items();
        item.add(new MeHeader());
        item.add(new MeText(R.drawable.code,R.string.me_qr_code));
        item.add(new MeText(R.drawable.pass,R.string.me_login_password));
        item.add(new MeText(R.drawable.pass2,R.string.me_purchase_password));
        item.add(new MeText(R.drawable.mess,R.string.me_push_msg));
        item.add(new MeText(R.drawable.lan,R.string.me_lan_change));
        item.add(new MeText(R.drawable.news,R.string.me_suggest));
        mAdapter.setItems(item);
        mAdapter.notifyDataSetChanged();
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
