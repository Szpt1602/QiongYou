package com.white.my.adatper;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Exp on 2016/6/8.
 */
public class Login_Vp_Adapter extends PagerAdapter {


    private List<View> list;

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = list.get(position);
        container.addView(list.get(position));
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    public Login_Vp_Adapter(List<View> list) {
        this.list=list;
    }

    public Login_Vp_Adapter() {
    }
}
