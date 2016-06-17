package com.white.other.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.white.R;

/**
 * Created by A8 on 2016/6/16.
 */
public class ProductActivity extends AppCompatActivity implements View.OnClickListener {

    private View back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initViews();
        initData();
        initEvent();

    }

    private void initViews() {
        back = findViewById(R.id.product_back_iv);
    }

    private void initData() {

    }

    private void initEvent() {
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.product_back_iv:
                finish();
                break;
        }
    }
}
