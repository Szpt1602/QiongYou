package com.white.other.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.white.other.ui.fragment.GuideFragment;

/**
 * Created by Exp on 2016/6/6.
 */
public class GuideAdapter extends FragmentPagerAdapter {

    int img [] ;

    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        GuideFragment guideFragment = new GuideFragment(position);
        Bundle bundle = new Bundle();
        bundle.putInt("img",img[position]);
        bundle.putBoolean("show",position==img.length-1);
        guideFragment.setArguments(bundle);

        return guideFragment;
    }

    @Override
    public int getCount() {
        return img==null?0:img.length;
    }

    public void setImg(int[] img) {
        this.img=img;
    }

}
