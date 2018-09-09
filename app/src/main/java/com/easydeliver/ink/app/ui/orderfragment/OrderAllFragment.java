package com.easydeliver.ink.app.ui.orderfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.utils.ScreenUtils;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;

import me.drakeet.multitype.Items;

/**
 * 全部订单
 */
public class OrderAllFragment extends BaseFragment{
    private CommonAdapter mAdapter;
    @Override
    public void initData(@Nullable Bundle bundle) {
        if (ScreenUtils.isPortrait()) {
            ScreenUtils.adaptScreen4VerticalSlide(this.getActivity(), 750);
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_order_all;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        RecyclerView mRecyclerView = contentView.findViewById(R.id.Rv_order_all);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL));
        mRecyclerView.addItemDecoration(new OrderIndexItemDecoration());
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(llm);
        mAdapter = new CommonAdapter();
        mAdapter.register(OrderItemHeaderBean.class, new OrderItemHeaderViewBinder());
        mAdapter.register(OrderItemProductBean.class, new OrderItemProductViewBinder());
        mAdapter.register(OrderItemFooterBean.class, new OrderItemFooterViewBinder());
        mAdapter.setScrollSaveStrategyEnabled(true);
        mRecyclerView.setAdapter(mAdapter);
        Items item = new Items();
        item.add(new OrderItemHeaderBean("https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg","武进区湖塘定安中路631号",
                1,"交易成功","孙二娘肉包子店",26.05,52.08,80.88,3.45));

        item.add(new OrderItemProductBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼01",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemProductBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼02",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemFooterBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼02",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemHeaderBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemProductBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼02",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemFooterBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼02",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));

        mAdapter.setItems(item);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }

    public static OrderAllFragment newInstance() {
        Bundle args = new Bundle();
        OrderAllFragment fragment = new OrderAllFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
