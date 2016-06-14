package com.white.idestination.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.white.idestination.bean.LocalBlock;
import com.white.idestination.widget.City_Fragment;

import java.util.List;

/**
 * Created by Administrator on 2016/6/13.
 */
public class CityBlockAdapter extends FragmentPagerAdapter {

    private int count;

    private List<LocalBlock> list;

    public CityBlockAdapter(FragmentManager fm, List<LocalBlock> list) {
        super(fm);
        this.list = list;
        count = 2;
    }

    @Override
    public Fragment getItem(int position) {
        City_Fragment cityFragment = new City_Fragment();
        if (list.size() - position * 6 > 3) {
            cityFragment.setData(list.subList(0, 6));
        } else {
            cityFragment.setData(list.subList(6, list.size()));

        }
        return cityFragment;
    }

    @Override
    public int getCount() {
        return count;
    }


}
