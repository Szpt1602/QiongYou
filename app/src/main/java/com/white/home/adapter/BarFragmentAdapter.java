package com.white.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.white.home.bean.HomeDetail;
import com.white.home.widget.BarFragment;

import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class BarFragmentAdapter extends FragmentPagerAdapter {

    private final List<HomeDetail> list;
    private final int count;
//.
    public BarFragmentAdapter(FragmentManager fm, List<HomeDetail> list) {
        super(fm);
        this.list = list;
        count = 2;
    }


    @Override
    public Fragment getItem(int position) {
        BarFragment barFragment = new BarFragment();
        if (list.size() - position * 8 > 4) {
            barFragment.setDataList(list.subList(0, 8));
        } else {
            barFragment.setDataList(list.subList(8, 12));
        }
        return barFragment;
    }

    @Override
    public int getCount() {
        return count;
    }
}
