package com.white.localleisure.ui;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.localleisure.adapter.MyPagerAdapter;
import com.white.localleisure.bean.LocalItemJson;
import com.white.localleisure.widget.LocalItem;
import com.white.localleisure.widget.LocalScrollItem;
import com.white.other.base.BaseFragment;
import com.white.other.utils.Constant;
import com.white.other.utils.HttpUtil;
import com.white.other.utils.JumpManager;
import com.white.other.widget.ViewPagerIndex;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/1.
 */
public class LocalFragment extends BaseFragment implements View.OnClickListener{

    private LinearLayout rootll;
    private String title;
    private String sub_title;
    private JSONArray recommend_ptype;
    private JSONArray recommend_lastm;
    private JSONArray top_sell;
    private List<LocalItemJson> ptype;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private String cover_pic;
    private TextView tv_title;
    private TextView tv_subtitle;
    private ImageView content_bg;
    private ViewPager viewPager;
    private List<LocalScrollItem> list = new ArrayList<>();
    private List<View> views;
    private ViewPagerIndex vpindex;
    private Button btn_city;
    private LinearLayout ll_01;
    private LinearLayout ll_02;
    private LinearLayout ll_03;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_local;
    }

    @Override
    protected void initViews() {
        rootll = (LinearLayout) root.findViewById(R.id.local_list_ll);
        tv1 = (TextView) root.findViewById(R.id.local_must_tv1);
        tv2 = (TextView) root.findViewById(R.id.local_must_tv2);
        tv3 = (TextView) root.findViewById(R.id.local_must_tv3);
        iv1 = (ImageView) root.findViewById(R.id.local_must_iv1);
        iv2 = (ImageView) root.findViewById(R.id.local_must_iv2);
        iv3 = (ImageView) root.findViewById(R.id.local_must_iv3);
        tv_title = (TextView) root.findViewById(R.id.local_title_tv);
        tv_subtitle = (TextView) root.findViewById(R.id.local_subtitle_tv);
        content_bg = (ImageView) root.findViewById(R.id.local_content_bg);
        viewPager = (ViewPager) root.findViewById(R.id.local_viewpager);
        vpindex = (ViewPagerIndex) root.findViewById(R.id.local_item_index);
        btn_city = (Button) root.findViewById(R.id.local_selector_city);
        ll_01 = (LinearLayout) root.findViewById(R.id.local_ll_01);
        ll_02 = (LinearLayout) root.findViewById(R.id.local_ll_02);
        ll_03 = (LinearLayout) root.findViewById(R.id.local_ll_03);
        btn_city.setOnClickListener(this);
        ll_01.setOnClickListener(this);
        ll_02.setOnClickListener(this);
        ll_03.setOnClickListener(this);
    }

    @Override
    protected void initEvents() {
        HttpUtil.doGet(Constant.HOT, new HttpUtil.RequestCallback() {
            @Override
            public void success(Object result) {
                try {
                    JSONObject json = new JSONObject((String) result);
                    JSONObject data = json.getJSONObject("data");
                    title = data.getString("title");
                    sub_title = data.getString("sub_title");
                    cover_pic = data.getString("cover_pic");
                    recommend_ptype = data.getJSONArray("recommend_ptype");
                    recommend_lastm = data.getJSONArray("recommend_lastm");
                    top_sell = data.getJSONArray("top_sell");
                    ptype = new LocalItemJson().arrayLocalItemFromData(recommend_ptype.toString());
                    addPtype(ptype);
                    List<LocalItemJson> topsell = new LocalItemJson().arrayLocalItemFromData(top_sell.toString());
                    addTopSell(topsell);
                    List<LocalItemJson> localItemJsons = new LocalItemJson().arrayLocalItemFromData(recommend_lastm.toString());
                    addlastm(localItemJsons);
                    setTop();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fail() {
                Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void initData() {
    }

    private void addPtype(List<LocalItemJson> list) {
        tv1.setText(list.get(0).getCatename());
        tv2.setText(list.get(1).getCatename());
        tv3.setText(list.get(2).getCatename());
        Glide.with(getActivity()).load(list.get(0).getIcon()).thumbnail(0.1f).into(iv1);
        Glide.with(getActivity()).load(list.get(1).getIcon()).thumbnail(0.1f).into(iv2);
        Glide.with(getActivity()).load(list.get(2).getIcon()).thumbnail(0.1f).into(iv3);

    }

    private void addTopSell(List<LocalItemJson> topsell) {
        for (int i = 0; i < topsell.size(); i++) {
            LocalItem localItem = new LocalItem(getActivity(), topsell.get(i));
            rootll.addView(localItem);
        }
    }

    private void setTop() {
        if (title != null && sub_title != null && cover_pic != null) {
            tv_title.setText(title);
            tv_subtitle.setText(sub_title);
            Glide.with(getContext()).load(cover_pic).thumbnail(0.1f).into(content_bg);
        }
    }

    private void addlastm(List<LocalItemJson> localItemJsons) {
        for (int i = 0; i < localItemJsons.size(); i++) {
            LocalScrollItem item = new LocalScrollItem(getActivity(), localItemJsons.get(i));
            list.add(item);
        }
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(50);
        MyPagerAdapter adapter = new MyPagerAdapter(list);
        viewPager.setAdapter(adapter);
        vpindex.setViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.local_selector_city:
                JumpManager.jumpToCityActivity(getActivity());
                break;
            case R.id.local_ll_01:
                Toast.makeText(getContext(),"01",Toast.LENGTH_SHORT).show();
                break;
            case R.id.local_ll_02:
                JumpManager.jumpToVisaActivity(getActivity());
                break;
            case R.id.local_ll_03:
                Toast.makeText(getContext(),"03",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
