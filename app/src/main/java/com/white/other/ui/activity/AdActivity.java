package com.white.other.ui.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.white.R;
import com.white.other.base.BaseActivity;

/**
 * Created by Exp on 2016/6/8.
 */
public class AdActivity extends BaseActivity {

    private ImageView iv;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_ad;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {
        iv = (ImageView) findViewById(R.id.activity_ad_iv);
        if (iv != null) {
            iv.setImageResource(R.drawable.bg_splash_default);
        }
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            Intent intent = new Intent(AdActivity.this, GuideActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    protected void initViews() {


//        initEvents();
    }
}
