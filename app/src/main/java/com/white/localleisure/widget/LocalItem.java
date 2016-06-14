package com.white.localleisure.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.white.R;
import com.white.localleisure.bean.LocalItemJson;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class LocalItem extends RelativeLayout{

    private static TextView tv_city;
    private static TextView tv_content;
    private static TextView tv_title;
    private static TextView tv_number;
    private static TextView tv_price;
    private static ImageView imageview;

    public LocalItem(Context context,LocalItemJson json) {
        super(context);
        inflate(context, R.layout.widget_local_item,this);
        tv_city = (TextView) findViewById(R.id.local_item_city);
        tv_content = (TextView) findViewById(R.id.local_item_content);
        tv_title = (TextView) findViewById(R.id.local_item_title);
        tv_number = (TextView) findViewById(R.id.local_item_number);
        tv_price = (TextView) findViewById(R.id.local_item_price);
        imageview = (ImageView) findViewById(R.id.local_item_iv);
        setLocalItem(json,context);
    }

    public LocalItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.widget_local_item,this);
        tv_city = (TextView) findViewById(R.id.local_item_city);
        tv_content = (TextView) findViewById(R.id.local_item_content);
        tv_title = (TextView) findViewById(R.id.local_item_title);
        tv_number = (TextView) findViewById(R.id.local_item_number);
        tv_price = (TextView) findViewById(R.id.local_item_price);
        imageview = (ImageView) findViewById(R.id.local_item_iv);
    }

    public void setLocalItem(final LocalItemJson json, Context context){
        final String name = json.getCity_name();
        tv_city.setText(json.getCity_name());
        tv_content.setText(json.getCate_short_name());
        tv_title.setText(json.getTitle());
        tv_number.setText(json.getSale_count()+"件已售");
        String price = json.getPrice();
        String pri = price.substring(4, price.length() - 7);
        tv_price.setText(pri);
        Glide.with(context).load(json.getPic()).thumbnail(0.1f).into(imageview);
        setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),name+"",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
