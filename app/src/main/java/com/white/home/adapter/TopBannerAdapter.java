package com.white.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.white.home.bean.HomeDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class TopBannerAdapter extends PagerAdapter {

    private final List<ImageView> views;

    public TopBannerAdapter(Fragment fragment, List<HomeDetail> list) {
        views = new ArrayList<>();
        for (HomeDetail hd : list) {
            ImageView imageView = new ImageView(fragment.getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                }
            });
            Glide.with(fragment)
                    .load(hd.getCover())
                    .crossFade()
                    .into(imageView);
            views.add(imageView);
        }
    }

    @Override
    public int getCount() {
        return views == null ? 0 : views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = views.get(position);
        container.addView(imageView);
        return imageView;
    }
}
