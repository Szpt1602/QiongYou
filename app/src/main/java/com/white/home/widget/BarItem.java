package com.white.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.home.bean.HomeDetail;

import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class BarItem extends LinearLayout {


    private TextView[] textViews;
    private ImageView[] imageViews;
    private View[] views;

    public BarItem(Context context, List<HomeDetail> list) {
        super(context);

        initViews(context);

        setData(list);
    }

    public BarItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        initViews(context);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.widget_bar_item, this);

        textViews = new TextView[]{
                (TextView) findViewById(R.id.widget_bar_tv1),
                (TextView) findViewById(R.id.widget_bar_tv2),
                (TextView) findViewById(R.id.widget_bar_tv3),
                (TextView) findViewById(R.id.widget_bar_tv4)
        };

        imageViews = new ImageView[]{
                (ImageView) findViewById(R.id.widget_bar_iv1),
                (ImageView) findViewById(R.id.widget_bar_iv2),
                (ImageView) findViewById(R.id.widget_bar_iv3),
                (ImageView) findViewById(R.id.widget_bar_iv4)
        };

        views = new View[]{
                findViewById(R.id.widget_bat_root1),
                findViewById(R.id.widget_bat_root2),
                findViewById(R.id.widget_bat_root3),
                findViewById(R.id.widget_bat_root4)
        };
    }

    public void setData(List<HomeDetail> list) {
        for (int i = 0; i < list.size(); i++) {
            HomeDetail homeDetail = list.get(i);
            Glide.with(getContext())
                    .load(homeDetail.getIcon())
                    .crossFade()
                    .into(imageViews[i]);
            textViews[i].setText(homeDetail.getName());
        }

    }
}
