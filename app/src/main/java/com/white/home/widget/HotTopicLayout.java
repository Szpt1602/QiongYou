package com.white.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.white.R;
import com.white.home.bean.HomeDetail;

import java.util.List;

/**
 * Created by A8 on 2016/6/6.
 */
public class HotTopicLayout extends LinearLayout {

    private LinearLayout root;

    public HotTopicLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        initViews(context);
    }

    public HotTopicLayout(Context context) {
        super(context);

        initViews(context);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.widget_hot_topic_layout, this);

        root = (LinearLayout) findViewById(R.id.hot_topic_root);
    }

    public void setData(List<HomeDetail> list) {
        root.removeAllViews();
        for (HomeDetail h : list) {
            root.addView(new HotTopicItem(getContext(), h));
        }
    }
}
