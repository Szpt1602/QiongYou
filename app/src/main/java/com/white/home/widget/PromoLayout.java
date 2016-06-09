package com.white.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.home.bean.HomeDetail;

import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class PromoLayout extends LinearLayout {

    private ImageView l;
    private ImageView rt;
    private ImageView bl;
    private ImageView br;

    public PromoLayout(Context context, List<HomeDetail> list) {
        super(context);

        initViews(context);

        setData(list);
    }

    public PromoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.widget_promo, this);

        l = (ImageView) findViewById(R.id.promo_left);
        rt = (ImageView) findViewById(R.id.promo_right_top);
        bl = (ImageView) findViewById(R.id.promo_bottom_left);
        br = (ImageView) findViewById(R.id.promo_bottom_right);
    }

    private void setData(List<HomeDetail> list) {
        Glide.with(getContext())
                .load(list.get(0).getImg())
                .into(l);

        Glide.with(getContext())
                .load(list.get(1).getImg())
                .into(rt);

        Glide.with(getContext())
                .load(list.get(2).getImg())
                .into(bl);

        Glide.with(getContext())
                .load(list.get(3).getImg())
                .into(br);
    }
}
