package com.easydeliver.ink.app.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.utils.FragmentUtils;
import com.easydeliver.ink.app.base.utils.ScreenUtils;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;

public class MainFragment extends BaseFragment
        implements FragmentUtils.OnBackClickListener {
    private static int SPAN_COUNT = 2;
    private CommonAdapter mAdapter;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {
        if (ScreenUtils.isPortrait()) {
         //   ScreenUtils.adaptScreen4VerticalSlide(this.getActivity(), 750);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        RecyclerView mRecyclerView = contentView.findViewById(R.id.rv);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getActivity(), SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                Object o = mAdapter.getItems().get(position);
                //* return o instanceof NewBean ?  SPAN_COUNT:1 ;*//*
                if (o instanceof NewBean) {
                    return 1;
                } else if (o instanceof MainNew) {
                    return 1;
                } else if (o instanceof MainHeader) {
                    return SPAN_COUNT;
                }
                return SPAN_COUNT;
            }

        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        // mRecyclerView.setBackgroundColor(ContextCompat.getColor(this.getActivity(), R.color.colorPrimary));
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new MainNewIndexItemDecoration());
        mAdapter = new CommonAdapter();
        //header

        mAdapter.register(MainHeader.class, new MainHeaderItemViewBinder());
        mAdapter.register(MainMenu.class, new MainMenuItemViewBinder());
        mAdapter.register(MainTitle.class, new MainTitleItemViewBinder());
        mAdapter.register(MainNew.class, new MainNewItemViewBinder());
        mAdapter.register(MainHotRecommand.class, new MainHotRecommandItemViewBinder());

        mAdapter.setScrollSaveStrategyEnabled(true);
        mRecyclerView.setAdapter(mAdapter);
        Items item = new Items();
        MainHeader header = new MainHeader();
        List<Banner> list = new ArrayList<>();
        list.add(new Banner("http://image4.xyzs.com/upload/47/44/1434771646463926/20150621/143488178199824_0.jpg", "01"));
        list.add(new Banner("http://img1.3lian.com/2015/a1/40/d/191.jpg", "02"));
        header.setBanner(list);
        item.add(header);
        item.add(new MainMenu());
        item.add(new MainTitle(R.string.main_new_recommand));
        item.add(new MainNew("https://uploadfile.bizhizu.cn/2017/0612/20170612114901844.jpg","迪丽热巴01"));
        item.add(new MainNew("http://img.ixiumei.com/uploadfile/2017/0619/20170619060323598.jpg","迪丽热巴02"));
        item.add(new MainNew("https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg","迪丽热巴03"));
        item.add(new MainTitle(R.string.main_hot_recommand));
        item.add(new MainHotRecommand("https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg","热门推荐01"));
        item.add(new MainHotRecommand("https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg","热门推荐02"));
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
