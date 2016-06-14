package com.white.idestination.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.white.R;
import com.white.idestination.bean.PtypeBlock;
import com.white.other.utils.ImageUtil;

/**
 * Created by Administrator on 2016/6/13.
 */
public class widget_des_ptype_item extends LinearLayout {

    private ImageView iv;
    private TextView tv;

    public widget_des_ptype_item(Context context) {
        super(context);
        initView(context);
    }

    public widget_des_ptype_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.widget_des_ptype_item, this);
        iv = (ImageView) findViewById(R.id.des_ptype_item_iv);
        tv = (TextView) findViewById(R.id.des_ptype_item_tv);
    }

    public void setItem(PtypeBlock block) {
        ImageLoader.getInstance().displayImage(block.getCover(), iv, ImageUtil.getCircleImageOptions());
        tv.setText(block.getName());
    }
}
