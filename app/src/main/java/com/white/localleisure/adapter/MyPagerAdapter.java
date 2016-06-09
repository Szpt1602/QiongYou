package com.white.localleisure.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.white.localleisure.widget.LocalScrollItem;

import java.util.List;

/**
 * Created by Administrator on 2016/6/8 0008.
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<LocalScrollItem> views;

    public MyPagerAdapter(List<LocalScrollItem> views) {
        this.views=views;
    }

    @Override
    public int getCount() {
        return views==null?0:views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LocalScrollItem localItem = views.get(position);
        container.addView(localItem);
        return localItem;

    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LocalScrollItem localItem = views.get(position);
        container.removeView(localItem);

    }
}
