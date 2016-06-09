package com.white.home.ui;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.white.R;
import com.white.home.adapter.BarFragmentAdapter;
import com.white.home.adapter.GearAdapter;
import com.white.home.adapter.HomeItemAdapter;
import com.white.home.adapter.TopBannerAdapter;
import com.white.home.bean.HomeBottom;
import com.white.home.bean.HomeData;
import com.white.home.bean.HomeDetail;
import com.white.home.util.HomeHttpUtil;
import com.white.home.widget.HotTopicLayout;
import com.white.home.widget.PromoLayout;
import com.white.other.base.BaseFragment;
import com.white.other.utils.HttpUtil;
import com.white.other.widget.LoadingMore;
import com.white.other.widget.MyScrollView;
import com.white.other.widget.ViewPagerIndex;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by A8 on 2016/6/1.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private ViewPagerIndex vp_index1;
    private ViewPagerIndex vp_index2;
    private ViewPager vp_banner;
    private SwipeRefreshLayout srl;
    private ViewPager vp_bar;
    private LinearLayout promo_root;
    private RecyclerView rv_gear;
    private HotTopicLayout hot_topic;
    private ListView lv;
    private MyScrollView sv;
    private View titleBg;
    private LoadingMore lm;
    private HomeItemAdapter itemAdapter;
    private View more;
    private Handler mHandler = new Handler();

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        setTitleView(R.layout.title_home_fragment);

        sv = (MyScrollView) root.findViewById(R.id.home_sv_root);
        lv = (ListView) root.findViewById(R.id.home_choiceness_lv);
        vp_index1 = (ViewPagerIndex) root.findViewById(R.id.home_top_vp_index1);
        vp_index2 = (ViewPagerIndex) root.findViewById(R.id.home_top_vp_index2);
        srl = (SwipeRefreshLayout) root.findViewById(R.id.home_srl);
        vp_banner = (ViewPager) root.findViewById(R.id.home_top_banner_vp);
        vp_bar = (ViewPager) root.findViewById(R.id.home_bar_root_vp);
        promo_root = (LinearLayout) root.findViewById(R.id.home_promo_root);
        rv_gear = (RecyclerView) root.findViewById(R.id.home_gear_rv);
        hot_topic = (HotTopicLayout) root.findViewById(R.id.home_top_topic);
        lm = (LoadingMore) root.findViewById(R.id.home_bottom_lm);
        more = root.findViewById(R.id.home_query_more);

        titleBg = getTitleView().findViewById(R.id.title_home_green);

        srl.setProgressViewOffset(false, 140, 280);

        srl.setColorSchemeColors(R.color.colorPrimaryDark, R.color.public_gray, R.color.public_green, R.color.black_trans20);

    }

    @Override
    protected void initEvents() {

        getTitleView().findViewById(R.id.ic_left_image).setOnClickListener(this);
        getTitleView().findViewById(R.id.ic_right_image).setOnClickListener(this);

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                requestData();
            }
        });

        sv.setScrollListener(new MyScrollView.ScrollStateListener() {

            @Override
            public void top() {
                titleBg.setAlpha(0);
            }

            @Override
            public void bottom() {
                lm.startLoad();
                requestChoiceness();
            }

            @Override
            public void scroll(int y, int oldy) {
                int measuredBannerHeight = vp_banner.getMeasuredHeight();
                int measuredTitleHeight = getTitleView().getMeasuredHeight();
                titleBg.setAlpha((float) y / (measuredBannerHeight - measuredTitleHeight));
            }
        });

    }

    private int page = 1;

    private void requestChoiceness() {
        HomeHttpUtil.getHomeChoicenessData(new HttpUtil.RequestCallback() {

            @Override
            public void success(Object result) {
                HomeBottom homeBottom = HomeBottom.objectFromData(result.toString());
                if (homeBottom.getData().size() == 0) {
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                            more.setVisibility(View.VISIBLE);
                            lm.setVisibility(View.GONE);
                        }
                    });
                    return;
                }
                lm.endLoad();
                itemAdapter.addData(homeBottom.getData());
            }

            @Override
            public void fail() {
                lm.endLoad();
            }
        }, page++, 10);
    }

    @Override
    protected void initData() {
        itemAdapter = new HomeItemAdapter(this);
        lv.setAdapter(itemAdapter);
        requestData();
    }

    private void requestData() {
        HomeHttpUtil.getHomeData(new HttpUtil.RequestCallback() {

            @Override
            public void success(Object result) {
                try {
                    JSONObject jsonObject = new JSONObject(result.toString());
                    JSONObject data = jsonObject.optJSONObject("data");

                    HomeData homeData = HomeData.objectFromData(data.toString());
                    showBanner(homeData.getHead_slide());
                    showBar(homeData.getBar());
                    showPromo(homeData.getPromo());
                    showGears(homeData.getGears());
                    showHotTopic(homeData.getHot_topic());

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                srl.setRefreshing(false);
            }

            @Override
            public void fail() {
                srl.setRefreshing(false);
            }
        });
    }

    private void showHotTopic(List<HomeDetail> hot_topic) {
        this.hot_topic.setData(hot_topic);
    }

    private void showGears(List<HomeDetail> gears) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_gear.setLayoutManager(linearLayoutManager);
        GearAdapter gearAdapter = new GearAdapter(this, gears);
        rv_gear.setAdapter(gearAdapter);
    }

    private void showPromo(List<HomeDetail> promo) {
        PromoLayout promoLayout = new PromoLayout(getActivity(), promo);
        promo_root.addView(promoLayout);
    }

    private void showBar(List<HomeDetail> bar) {

        BarFragmentAdapter fragmentAdapter = new BarFragmentAdapter(getActivity().getSupportFragmentManager(), bar);
        vp_bar.setAdapter(fragmentAdapter);
        vp_index2.setViewPager(vp_bar);

    }

    private void showBanner(HomeData.HeadSlideBean head_slide) {
        TopBannerAdapter bannerAdapter = new TopBannerAdapter(this, head_slide.getSlide_data());
        vp_banner.setAdapter(bannerAdapter);
        vp_index1.setViewPager(vp_banner);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
