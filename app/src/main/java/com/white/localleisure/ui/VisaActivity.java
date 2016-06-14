package com.white.localleisure.ui;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.localleisure.adapter.LocalVisaAdapter;
import com.white.localleisure.bean.LocalVisaJson;
import com.white.localleisure.widget.LocalCountry;
import com.white.localleisure.widget.VisaItem;
import com.white.other.base.BaseActivity;
import com.white.other.utils.Constant;
import com.white.other.utils.HttpUtil;
import com.white.other.widget.ViewPagerIndex;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VisaActivity extends BaseActivity {


    private ViewPager viewPager;
    private ViewPagerIndex vpi;
    private LinearLayout rootll;
    private LinearLayout ll;
    private LinearLayout ll2;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_visa;
    }

    @Override
    protected void initData() {
        HttpUtil.doGet(Constant.LOCAL_VISAURL, new HttpUtil.RequestCallback() {

            @Override
            public void success(Object result) {
                try {
                    JSONObject json = new JSONObject(result.toString());
                    String str = json.getString("trace_switch");

                    if(str.equals("true")){

                        JSONObject data = json.getJSONObject("data");
                        JSONArray slide = data.getJSONArray("slide");
                        JSONArray destination = data.getJSONArray("destination");
                        JSONArray top_sell = data.getJSONArray("top_sell");

                        List<LocalVisaJson> slide_list = LocalVisaJson.arrayLocalVisaJsonFromData(slide.toString());
                        List<LocalVisaJson> destination_list = LocalVisaJson.arrayLocalVisaJsonFromData(destination.toString());
                        List<LocalVisaJson> top_sell_list = LocalVisaJson.arrayLocalVisaJsonFromData(top_sell.toString());

                        addViewPager(slide_list);
                        addCountry(destination_list);
                        addCommodity(top_sell_list);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void fail() {

            }
        });


    }




    @Override
    protected void initEvents() {

    }

    @Override
    protected void initViews() {
        viewPager = (ViewPager) findViewById(R.id.local_visa_vp);
        vpi = (ViewPagerIndex) findViewById(R.id.local_visa_vpi);
        rootll = (LinearLayout) findViewById(R.id.local_visa_rootll);
        ll = (LinearLayout) findViewById(R.id.local_visa_ll);
        ll2 = (LinearLayout) findViewById(R.id.local_visa_ll2);
    }

    private void addViewPager(final List<LocalVisaJson> slide_list) {
        List<ImageView> images=new ArrayList<>();
        for (int i=0;i<slide_list.size();i++){
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Glide.with(this).load(slide_list.get(i).getImg()).thumbnail(0.1f).into(imageView);
            images.add(imageView);
        }
        LocalVisaAdapter adapter = new LocalVisaAdapter(images);
        viewPager.setAdapter(adapter);
        vpi.setViewPager(viewPager);
    }

    private void addCountry(List<LocalVisaJson> destination_list) {
        if(destination_list.size()==9){
            List<LocalVisaJson> list1 = destination_list.subList(0, 3);
            List<LocalVisaJson> list2 = destination_list.subList(3, 6);
            List<LocalVisaJson> list3 = destination_list.subList(6, 9);
            List<List<LocalVisaJson>> lists = new ArrayList<>();
            lists.add(list1);
            lists.add(list2);
            lists.add(list3);
            for (int i=0;i<3;i++){
                LocalCountry localCountry = new LocalCountry(this,lists.get(i));
                ll.addView(localCountry);
            }
        }
    }
    private void addCommodity(List<LocalVisaJson> top_sell_list) {

        for(int i=0;i<top_sell_list.size();i++){
            VisaItem visaItem = new VisaItem(this, top_sell_list.get(i));
            ll2.addView(visaItem);
        }
    }

}
