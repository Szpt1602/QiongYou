package com.white.localleisure.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.localleisure.bean.LocalVisaJson;

import java.util.List;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class LocalCountry extends LinearLayout {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    public LocalCountry(Context context,List<LocalVisaJson> list) {
        super(context);
        inflate(context, R.layout.widget_logcal_country,this);
        image1 = (ImageView) findViewById(R.id.local_country_iv1);
        image2 = (ImageView) findViewById(R.id.local_country_iv2);
        image3 = (ImageView) findViewById(R.id.local_country_iv3);
        tv1 = (TextView) findViewById(R.id.local_country_tv1);
        tv2 = (TextView) findViewById(R.id.local_country_tv2);
        tv3 = (TextView) findViewById(R.id.local_country_tv3);
        setLocalCountry(list);
    }

    public LocalCountry(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_logcal_country,this);
        image1 = (ImageView) findViewById(R.id.local_country_iv1);
        image2 = (ImageView) findViewById(R.id.local_country_iv2);
        image3 = (ImageView) findViewById(R.id.local_country_iv3);
        tv1 = (TextView) findViewById(R.id.local_country_tv1);
        tv2 = (TextView) findViewById(R.id.local_country_tv2);
        tv3 = (TextView) findViewById(R.id.local_country_tv3);
    }
    public void setLocalCountry(List<LocalVisaJson> list){
       if (list!=null){
                String pic = list.get(0).getPic();
                Glide.with(getContext()).load(pic).thumbnail(0.1f).into(image1);
                tv1.setText(list.get(0).getName());
                String pic2 = list.get(1).getPic();
                Glide.with(getContext()).load(pic2).thumbnail(0.1f).into(image2);
                tv2.setText(list.get(1).getName());
                String pic3 = list.get(2).getPic();
                Glide.with(getContext()).load(pic3).thumbnail(0.1f).into(image3);
                tv3.setText(list.get(2).getName());
       }
    }
}
