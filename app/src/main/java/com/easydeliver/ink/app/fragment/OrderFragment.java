package com.easydeliver.ink.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.utils.FragmentUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends BaseFragment
        implements FragmentUtils.OnBackClickListener {
    public static OrderFragment newInstance() {
        Bundle args = new Bundle();
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        RecyclerView mRecyclerView = contentView.findViewById(R.id.order_rv);
        RVAdapter adapter = new RVAdapter();

        adapter.setData(mockData());
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL));

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    private List<String> mockData(){
        List<String> datas = new ArrayList<>();
        for(int i=0;i<100;i++){
            datas.add("这是第"+i+ "个item ");
        }

        return datas;
    }


    public static class RVAdapter extends RecyclerView.Adapter{
        private List<String> mData;

        public void setData(List<String> data) {
            mData = data;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new InflateViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_test_item,null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            InflateViewHolder viewHolder = (InflateViewHolder) holder;
            viewHolder.mTextView.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0:mData.size();
        }

        public static class InflateViewHolder extends RecyclerView.ViewHolder{
            private TextView mTextView;
            public InflateViewHolder(View itemView) {
                super(itemView);
                mTextView = itemView.findViewById(R.id.text_item);
            }
        }
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
