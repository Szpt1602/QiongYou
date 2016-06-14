package com.white.idestination.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.white.R;
import com.white.idestination.bean.LocalBlock;
import com.white.other.utils.ImageUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/6/13.
 */
public class widget_des_loacl_item extends LinearLayout {

    private ImageView iv1, iv2;
    private ImageView below_iv1, below_iv2, below_iv3, below_iv4;

    public widget_des_loacl_item(Context context) {
        super(context);
        initView(context);
    }

    public widget_des_loacl_item(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.widget_des_loacl_item, this);
        iv1 = (ImageView) findViewById(R.id.des_local_item_iv1);
        iv2 = (ImageView) findViewById(R.id.des_local_item_iv2);
        below_iv1 = (ImageView) findViewById(R.id.des_local_item_below_iv1);
        below_iv2 = (ImageView) findViewById(R.id.des_local_item_below_iv2);
        below_iv3 = (ImageView) findViewById(R.id.des_local_item_below_iv3);
        below_iv4 = (ImageView) findViewById(R.id.des_local_item_below_iv4);
    }

    public void setItem(List<LocalBlock> block) {
        ImageLoader.getInstance().displayImage(block.get(0).getCover(), iv1, ImageUtil.getNormalImageOptions());
        ImageLoader.getInstance().displayImage(block.get(1).getCover(), iv2, ImageUtil.getNormalImageOptions());
        ImageLoader.getInstance().displayImage(block.get(2).getCover(), below_iv1, ImageUtil.getNormalImageOptions());
        ImageLoader.getInstance().displayImage(block.get(3).getCover(), below_iv2, ImageUtil.getNormalImageOptions());
        ImageLoader.getInstance().displayImage(block.get(4).getCover(), below_iv3, ImageUtil.getNormalImageOptions());
        ImageLoader.getInstance().displayImage(block.get(5).getCover(), below_iv4, ImageUtil.getNormalImageOptions());
    }
}
