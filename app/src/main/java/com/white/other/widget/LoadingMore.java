package com.white.other.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.white.R;

/**
 * Created by A8 on 2016/6/6.
 */
public class LoadingMore extends RelativeLayout {

    private ImageView iv;
    private AnimationDrawable drawable;

    public LoadingMore(Context context) {
        super(context);
    }

    public LoadingMore(Context context, AttributeSet attrs) {
        super(context, attrs);

        initViews(context);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.widget_loading_more, this);

        iv = (ImageView) findViewById(R.id.widget_loading_more_iv);
        drawable = (AnimationDrawable) iv.getDrawable();
    }

    public void startLoad() {
        drawable.start();
    }

    public void endLoad() {
        drawable.stop();
    }

    public boolean isLoading() {
        return drawable.isRunning();
    }
}
