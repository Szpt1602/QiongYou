package com.white.other.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.white.R;
import com.white.other.adapter.GuideAdapter;
import com.white.other.widget.ViewPagerIndex;

/**
 * Created by Exp on 2016/6/6.
 */
public class GuideActivity extends AppCompatActivity {


    public int imageId[]={R.drawable.bg_splash3, R.drawable.bg_splash2,
            R.drawable.bg_splash1, R.drawable.bg_splash4};

     private Button btn;
    private ViewPager vp;
    private ViewPagerIndex index;
    private GuideAdapter guideAdapter;
    private Fragment lastFragment;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initViews();

        initEvents();

        initDate();

    }

    private void initDate() {
        guideAdapter = new GuideAdapter(getSupportFragmentManager());
        guideAdapter.setImg(imageId);
        vp.setAdapter(guideAdapter);
    }

    private void initViews() {
        vp = (ViewPager) findViewById(R.id.guide_activity_vp);
        index = (ViewPagerIndex) findViewById(R.id.guide_activity_index);
    }

    private void initEvents() {


        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                index.setIndex(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
