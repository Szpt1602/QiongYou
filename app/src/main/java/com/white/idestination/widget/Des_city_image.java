package com.white.idestination.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.white.R;
import com.white.idestination.bean.Des_City_Name1;
import com.white.idestination.bean.LocalBlock;
import com.white.idestination.bean.PtypeBlock;
import com.white.other.utils.ImageUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Des_city_image extends RelativeLayout {

    private widget_des_ptype_item d1, d2, d3, d4, d5;
    private widget_des_loacl_item loacl_item;
    private ImageView iv;
    private TextView tv_ch, tv_en;
    private ViewPager vp;

    public Des_city_image(Context context, Des_City_Name1 dcn, String cityId) {
        super(context);
        initView(context);
        setDesCityIamge(dcn);
        setPtypeItem(dcn);
        if (cityId != null) {
            vp.setVisibility(GONE);
            setLoaclItem(dcn);
        } else {
            loacl_item.setVisibility(GONE);

        }
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
        d1 = (widget_des_ptype_item) findViewById(R.id.des_ptype_i1);
        d2 = (widget_des_ptype_item) findViewById(R.id.des_ptype_i2);
        d3 = (widget_des_ptype_item) findViewById(R.id.des_ptype_i3);
        d4 = (widget_des_ptype_item) findViewById(R.id.des_ptype_i4);
        d5 = (widget_des_ptype_item) findViewById(R.id.des_ptype_i5);
        loacl_item = (widget_des_loacl_item) findViewById(R.id.des_loacl_item);
        vp = (ViewPager) findViewById(R.id.des_loacl_item_vp);
    }


    private void setDesCityIamge(Des_City_Name1 dcn) {
        ImageLoader.getInstance().displayImage(dcn.getCover(), iv, ImageUtil.getNormalImageOptions());
        tv_ch.setText(dcn.getName());
        tv_en.setText(dcn.getEnname());
    }

    private void setPtypeItem(Des_City_Name1 dcn) {
        List<PtypeBlock> block = dcn.getPtype_block();
        d1.setItem(block.get(0));
        d2.setItem(block.get(1));
        d3.setItem(block.get(2));
        d4.setItem(block.get(3));
        d5.setItem(block.get(4));
    }

    private void setLoaclItem(Des_City_Name1 dcn) {
        List<LocalBlock> block = dcn.getLocal_block();
        loacl_item.setItem(block);
    }


}
