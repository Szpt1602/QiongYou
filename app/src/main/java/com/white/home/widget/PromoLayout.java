package com.white.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.home.bean.HomeDetail;
import com.white.other.utils.JumpManager;

import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class PromoLayout extends LinearLayout {

    private ImageView l;
    private ImageView rt;
    private ImageView bl;
    private ImageView br;

    private ImageView[] views;

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

        views = new ImageView[]{l, rt, bl, br};
    }

    private void setData(List<HomeDetail> list) {

        for (int i = 0; i < list.size(); i++) {
            Glide.with(getContext())
                    .load(list.get(i).getImg())
                    .into(views[i]);
            setListener(views[i], list.get(i).getUrl());
        }

    }

    private void setListener(View v, final String url) {
        v.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                JumpManager.jumpToWebNormalActivity(getContext(), url);
            }
        });
    }
}
