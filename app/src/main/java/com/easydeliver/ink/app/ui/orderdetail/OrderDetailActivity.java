package com.easydeliver.ink.app.ui.orderdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseActivity;
import com.easydeliver.ink.app.base.ui.IconFontTextView;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;
import com.easydeliver.ink.app.ui.orderfragment.OrderIndexItemDecoration;
import com.easydeliver.ink.app.ui.orderfragment.OrderItemFooterBean;
import com.easydeliver.ink.app.ui.orderfragment.OrderItemHeaderBean;
import com.easydeliver.ink.app.ui.orderfragment.OrderItemProductBean;

import me.drakeet.multitype.Items;

public class OrderDetailActivity extends BaseActivity{
    private IconFontTextView tv_back;
    private RecyclerView mRecyclerView;
    private CommonAdapter mAdapter;
    @Override
    public void initData(@Nullable Bundle bundle) {
       // ScreenUtils.adaptScreen4VerticalSlide(this,750);
    }

    @Override
    public int bindLayout() {
        return R.layout.act_order_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        tv_back = contentView.findViewById(R.id.tv_back);
        mRecyclerView = contentView.findViewById(R.id.rv_order_detail);
        tv_back.setOnClickListener(this);
        mRecyclerView.addItemDecoration(new OrderIndexItemDecoration());
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(llm);
        mAdapter = new CommonAdapter();
        mAdapter.register(OrderItemHeaderBean.class, new OrderDetailItemHeaderViewBinder());
        mAdapter.register(OrderItemProductBean.class, new OrderDetailItemProductViewBinder());
        mAdapter.register(OrderItemFooterBean.class, new OrderDetailItemFooterViewBinder());
        mAdapter.register(OrderDetailItemAdressAndTimeBean.class, new OrderDetailItemAdressViewBinder());
        mAdapter.register(OrderDetailItemOrderIdBean.class, new OrderDetailItemOrderIdViewBinder());
        mAdapter.setScrollSaveStrategyEnabled(true);
        mRecyclerView.setAdapter(mAdapter);
        Items item = new Items();
        item.add(new OrderItemHeaderBean("https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg","武进区湖塘定安中路631号",
                1,"交易成功","孙二娘肉包子店",26.05,52.08,80.88,3.45));
        item.add(new OrderItemProductBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼01",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemProductBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼01",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderItemFooterBean("https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","武进区武进万达广场3楼02",
                1,"交易成功","孙二娘肉包子店",20.05,43.06,80.88,3.45));
        item.add(new OrderDetailItemAdressAndTimeBean(R.drawable.address,"2018/08/24 周末 08:00-10:00",
                R.string.order_receive_info,"张三丰","18055827608","福建省厦门市云顶北路99号"));
        item.add(new OrderDetailItemAdressAndTimeBean(R.drawable.time,"2018/08/24 周末 08:00-10:00",
                R.string.order_receive_time,"张三丰","18055827608","福建省厦门市云顶北路99号"));
        item.add(new OrderDetailItemOrderIdBean("123456789012345678","2018/08/24 08:00-10:00",
                "2018/08/25 08:00-10:00","2018/08/26 08:00-10:00","2018/08/24 08:00-10:00"));
        mAdapter.setItems(item);
        mAdapter.notifyDataSetChanged();



    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()){
            case R.id.tv_back:
                finish();
                break;
        }
    }
}
