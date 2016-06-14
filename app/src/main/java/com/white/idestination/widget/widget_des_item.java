package com.white.idestination.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.white.R;
import com.white.idestination.bean.LocalBlock;
import com.white.other.utils.ImageUtil;

/**
 * Created by Administrator on 2016/6/13.
 */
public class widget_des_item extends LinearLayout {

    RelativeLayout relativeContainer;
    ImageView iv;
    TextView tv_ch, tv_en;

    public widget_des_item(Context context) {
        super(context);
        initView(context);
    }

    public widget_des_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    private void initView(Context context) {
        inflate(context, R.layout.widget_des_item, this);
        relativeContainer = (RelativeLayout) findViewById(R.id.des_item_rootrl);
        iv = (ImageView) findViewById(R.id.des_item_iv);
        tv_ch = (TextView) findViewById(R.id.des_item_ch_tv);
        tv_en = (TextView) findViewById(R.id.des_item_en_tv);
    }

    public void setDesItem(LocalBlock block) {
        ImageLoader.getInstance().displayImage(block.getCover(), iv, ImageUtil.getNormalImageOptions());
        tv_en.setText(block.getEnname());
        tv_ch.setText(block.getName());
    }

}
