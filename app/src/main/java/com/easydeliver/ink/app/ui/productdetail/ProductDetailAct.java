package com.easydeliver.ink.app.ui.productdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.common.statusbar.StatusBarCompat;
import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseActivity;
import com.easydeliver.ink.app.base.utils.ScreenUtils;
import com.easydeliver.ink.app.base.widget.adapter.CommonAdapter;
import com.easydeliver.ink.app.main.Banner;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.Items;

public class ProductDetailAct extends BaseActivity {
    private RecyclerView  mRecyclerView;
    private CommonAdapter mAdapter;
    @Override
    public void initData(@Nullable Bundle bundle) {
       // ScreenUtils.adaptScreen4VerticalSlide(this,750);
    }

    @Override
    public int bindLayout() {
        return R.layout.act_productdetail;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        StatusBarCompat.translucentStatusBar(this,true);
        mRecyclerView = contentView.findViewById(R.id.rv_productdetail);
        LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(llm);
        mAdapter = new CommonAdapter();
        mAdapter.register(ProductDetailItemBannerBean.class, new ProductDetailItemBannerViewBinder());
        mAdapter.register(ProductDetailItemTextBean.class, new ProductDetailItemTextViewBinder());
        mAdapter.setScrollSaveStrategyEnabled(true);
        mRecyclerView.setAdapter(mAdapter);
        Items item = new Items();
        List<Banner> list = new ArrayList<>();
        list.add(new Banner("https://uploadfile.bizhizu.cn/2017/0612/20170612114901844.jpg","迪丽热巴01"));
        list.add(new Banner("http://img.ixiumei.com/uploadfile/2017/0619/20170619060323598.jpg","迪丽热巴02"));
        list.add(new Banner("https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg","迪丽热巴03"));
        item.add(new ProductDetailItemBannerBean(list));
        item.add(new ProductDetailItemTextBean("哥伦比亚冻干低音咖啡","即时冲泡，媲美现磨",
                36.00,52.00,"门店折扣，5折优惠",260,"大家在项目中,比如购物类,有原价和折扣价这样很可能就需要对原价添加删除线,对折扣价添加加粗效果等等.而给TextView添加超链接,个人认为加点击事件就可以解决了.好了,下面贴一张效果图供大家直观地看一下."
        , "张勇加入阿里巴巴已经十一年，自担任阿里巴巴集团CEO以来，展现出了卓越的商业才华和坚定沉着的领导力，连续13季度实现阿里巴巴业绩健康持续增长。他具有超级计算机般的逻辑和思考能力，坚信使命愿景，勇于担当，全情投入，敢于站在未来创新设计新型商业模式和业态。他被评为中国 2018 年最佳CEO排名第一，这份荣誉当之无愧！\n" +
                "\n" +
                "\n" +
                "\n" +
                "他和他的团队已经赢得了客户、员工和股东们的信任和支持。阿里巴巴的接力火炬交给他和他领导的团队，我认为这是我现在最应该做的最正确决定。这几年我和张勇的合作配合经历，让我对他和他领导的新一代阿里巴巴领导团队充满信心！"));
        mAdapter.setItems(item);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onWidgetClick(View view) {

    }
}
