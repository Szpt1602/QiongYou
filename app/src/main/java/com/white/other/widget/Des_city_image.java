package com.white.other.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.white.R;
import com.white.idestination.bean.Des_City_Name1;
import com.white.other.utils.ImageUtil;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Des_city_image extends RelativeLayout {

    private ImageView iv;
    private TextView tv_ch, tv_en;

    public Des_city_image(Context context, Des_City_Name1 dcn) {
        super(context);
        initView(context);
        setDesCityIamge(dcn);
    }

    public Des_city_image(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.widget_des_city_iamge, this);
        iv = (ImageView) findViewById(R.id.des_city_image_iv);
        tv_ch = (TextView) findViewById(R.id.des_city_image_ch_tv);
        tv_en = (TextView) findViewById(R.id.des_city_image_en_tv);
    }

    private void setDesCityIamge(Des_City_Name1 dcn) {
        ImageLoader.getInstance().displayImage(dcn.getCover(), iv, ImageUtil.getNormalImageOptions());
        tv_ch.setText(dcn.getName());
        tv_en.setText(dcn.getEnname());
    }

}
