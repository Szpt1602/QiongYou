package com.white.other.base;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.white.R;

/**
 * Created by A8 on 2016/6/3.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ViewGroup content;
    private ImageView leftBtn;
    private ImageView rightBtn;
    private TextView title;
    private View titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        initBase();

        initViews();
        initEvents();
        initData();
    }


    private void initBase() {

        content = (ViewGroup) findViewById(R.id.base_act_content_ll);
        leftBtn = (ImageView) findViewById(R.id.base_ic_left);
        rightBtn = (ImageView) findViewById(R.id.base_ic_right);
        title = (TextView) findViewById(R.id.base_tv_title);
        titleBar = findViewById(R.id.base_act_custom_title_bar_root);

        View view = getLayoutInflater().inflate(getLayoutResId(), null);
        content.addView(view);
    }

    protected void setTileDrawable(Drawable leftDrawable, Drawable rightDrawable) {
        leftBtn.setImageDrawable(leftDrawable);
        rightBtn.setImageDrawable(rightDrawable);
    }

    protected void setTitleBackground(Drawable drawable) {
        titleBar.setBackgroundDrawable(drawable);
    }

    protected void setTitleText(String text) {
        if (!TextUtils.isEmpty(text)) {
            title.setText(text);
        }
    }

    protected abstract int getLayoutResId();

    protected abstract void initData();

    protected abstract void initEvents();

    protected abstract void initViews();


}
