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

/**
 * Created by A8 on 2016/6/6.
 */
public class HotTopicItem extends LinearLayout {

    private ImageView iv;

    public HotTopicItem(Context context, HomeDetail homeDetail) {
        super(context);

        initViews(context);

        setIv(homeDetail);
    }

    public HotTopicItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        initViews(context);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.widget_hot_topic_item, this);

        iv = (ImageView) findViewById(R.id.hot_topic_iv);
    }

    private void setIv(final HomeDetail homeDetail) {
        Glide.with(getContext())
                .load(homeDetail.getImg())
                .into(iv);

        iv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                JumpManager.jumpToWebNormalActivity(getContext(),homeDetail.getUrl());
            }
        });
    }


}
