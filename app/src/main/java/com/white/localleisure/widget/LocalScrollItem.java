package com.white.localleisure.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.localleisure.bean.LocalItemJson;

/**
 * Created by Administrator on 2016/6/8 0008.
 */
public class LocalScrollItem extends LinearLayout {

    private ImageView image;
    private TextView title;
    private TextView price;
    private TextView number;

    public LocalScrollItem(Context context, LocalItemJson json) {
        super(context);
        inflate(context, R.layout.widget_local_scroll_item, this);
        image = (ImageView) findViewById(R.id.local_scroll_image);
        title = (TextView) findViewById(R.id.local_scroll_title);
        price = (TextView) findViewById(R.id.local_scroll_price);
        number = (TextView) findViewById(R.id.local_scroll_number);
        setLocalScrolljson(json);
    }

    public LocalScrollItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_local_scroll_item,this);
        image = (ImageView) findViewById(R.id.local_scroll_image);
        title = (TextView) findViewById(R.id.local_scroll_title);
        price = (TextView) findViewById(R.id.local_scroll_price);
        number = (TextView) findViewById(R.id.local_scroll_number);
    }


    public void setLocalScrolljson(LocalItemJson json) {
        Glide.with(getContext()).load(json.getPic()).into(image);
        title.setText(json.getTitle());
        String prices = json.getPrice();
        String pri = prices.substring(4, prices.length() - 7);
        price.setText(pri);
        number.setText(json.getSale_count()+"件已售");
    }
}
