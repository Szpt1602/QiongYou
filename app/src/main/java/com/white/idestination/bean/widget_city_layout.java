package com.white.idestination.bean;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.white.R;
import com.white.idestination.widget.widget_des_item;

import java.util.List;

/**
 * Created by Administrator on 2016/6/13.
 */
public class widget_city_layout extends LinearLayout {

    private widget_des_item wdi1, wdi2, wdi3;
    private widget_des_item wdi4, wdi5, wdi6;

    public widget_city_layout(Context context) {
        super(context);
        initView(context);
    }

    public widget_city_layout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.widget_city_layout, this);
        wdi1 = (widget_des_item) findViewById(R.id.wdi1);
        wdi2 = (widget_des_item) findViewById(R.id.wdi2);
        wdi3 = (widget_des_item) findViewById(R.id.wdi3);
        wdi4 = (widget_des_item) findViewById(R.id.wdi4);
        wdi5 = (widget_des_item) findViewById(R.id.wdi5);
        wdi6 = (widget_des_item) findViewById(R.id.wdi6);
    }

    private void setItemLayout(List<LocalBlock> list) {

    }


}
