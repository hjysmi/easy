package com.easydeliver.ink.app.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.easydeliver.ink.app.R;
import com.easydeliver.ink.app.base.BaseFragment;
import com.easydeliver.ink.app.base.banner.BannerAdapter;
import com.easydeliver.ink.app.base.banner.SmartViewPager;
import com.easydeliver.ink.app.base.utils.FragmentUtils;
import com.easydeliver.ink.app.main.Banner;

import java.util.ArrayList;
import java.util.List;

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
        return R.layout.fragment_me;
    }

    @Override
    public void initView(Bundle savedInstanceState, View contentView) {
        TextView tv = contentView.findViewById(R.id.tvText);
       // ImageView iv = contentView.findViewById(R.id.iv);
        tv.setText("Me");
      //  ImageUtil.load(iv, "", 10, 20);
      SmartViewPager banner = contentView.findViewById(R.id.banner);
        banner.setNeedCirculate(true);
        banner.setNeedAutoScroll(true);
        banner.setIndicatorGravity(Gravity.BOTTOM | Gravity.CENTER);
        banner.setIndicatorColor(ContextCompat.getColor(contentView.getContext(), R.color.theme_color_primary),
                ContextCompat.getColor(contentView.getContext(), R.color.colorPrimary));
           /* int height = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.top_banner_height);
            ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(1920, height);
            banner.setLayoutParams(params);*/
        MeBannerAdapter    adapter = new MeBannerAdapter(contentView.getContext());
        List<Banner> list = new ArrayList<>();
        list.add(new Banner("http://pic1.win4000.com/wallpaper/2017-11-17/5a0e56930851f.jpg","1>hello"));
        list.add(new Banner("http://pic1.win4000.com/wallpaper/7/5822be39a1231.jpg","2>world"));
        adapter.setData(list, true);
        banner.setAdapter(adapter);


    }
    private class MeBannerAdapter  extends BannerAdapter<Banner, /*SimpleDraweeView*/ ImageView> {
        Context context;
        public MeBannerAdapter(Context context) {
            this.context = context;
        }

        @Override
        protected int getLayoutId() {
            return 0;
        }

        @Override
        protected ImageView getItemView() {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ViewGroup.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
            return imageView;
        }

        @Override
        protected void bindData(ImageView itemView, Banner item) {
           // itemView.setImageDrawable(context.getResources().getDrawable(R.drawable.banner01));
            itemView.setImageURI(Uri.parse(item.getUrl()));
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
