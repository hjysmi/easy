package com.easydeliver.ink.app.ui.shop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;
import com.easydeliver.ink.app.ui.orderfragment.OrderIndexItemDecoration;

import me.drakeet.multitype.Items;
import me.jessyan.autosize.internal.CustomAdapt;

/**
 *分店-顺带购物
 */
public class ShopBtwFragment extends BaseFragment implements CustomAdapt {
    CommonAdapter mAdapter;
    public static Fragment newInstance() {
        Bundle args = new Bundle();
        ShopBtwFragment fragment = new ShopBtwFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_shop_btw;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        RecyclerView rv_wash_btw = contentView.findViewById(R.id.rv_wash_btw);
        rv_wash_btw.addItemDecoration(new OrderIndexItemDecoration());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        rv_wash_btw.setLayoutManager(llm);
        mAdapter = new CommonAdapter();
        mAdapter.register(ShopWashBtwItemBean.class, new ShopWashBtwItemViewBinder());
        mAdapter.setScrollSaveStrategyEnabled(true);
        rv_wash_btw.setAdapter(mAdapter);
        Items item = new Items();

        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fv5n6daacqj30sg10f1dw.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        item.add(new ShopWashBtwItemBean("哥伦比亚冻干低吟咖啡","即时冲泡，媲美现磨",26.00,260,1,
                "https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg"));
        mAdapter.setItems(item);
        mAdapter.notifyDataSetChanged();

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
