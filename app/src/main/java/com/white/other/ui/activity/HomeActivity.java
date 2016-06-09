package com.white.other.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.white.R;
import com.white.home.ui.HomeFragment;
import com.white.idestination.ui.DesFragment;
import com.white.localleisure.ui.LocalFragment;
import com.white.my.ui.MyFragment;

/**
 * Created by A8 on 2016/6/1.
 */
public class HomeActivity extends AppCompatActivity {

    private RadioGroup rg;
    private FrameLayout content_fl;
    private FragmentManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        manager = getSupportFragmentManager();

        initViews();
        initFragments();
        initEvents();
    }

    private void initViews() {
        rg = (RadioGroup) findViewById(R.id.home_rg);
        content_fl = (FrameLayout) findViewById(R.id.home_content_fl);
    }

    private Fragment[] fragments;

    private void initFragments() {
        FragmentTransaction transaction = manager.beginTransaction();
        fragments = new Fragment[]{
                new HomeFragment(),
                new DesFragment(),
                new LocalFragment(),
                new MyFragment()
        };

        for (int i = 0; i < 4; i++) {
            transaction.add(R.id.home_content_fl, fragments[i], "Fragment" + i);
            transaction.hide(fragments[i]);
        }
        transaction.show(fragments[0]);
        transaction.commit();

    }

    private int lastIndex = 0;

    private void initEvents() {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                int index = 0;
                switch (checkedId) {
                    case R.id.home_rb_home:
                        if (lastIndex == 0)
                            return;
                        index = 0;
                        break;
                    case R.id.home_rb_des:
                        if (lastIndex == 1) {
                            return;
                        }
                        index = 1;
                        break;
                    case R.id.home_rb_local:
                        if (lastIndex == 2) {
                            return;
                        }
                        index = 2;
                        break;
                    case R.id.home_rb_my:
                        if (lastIndex == 3) {
                            return;
                        }
                        index = 3;
                        break;
                }
                transaction.hide(fragments[lastIndex]);
                transaction.show(fragments[index]);
                transaction.commit();
                lastIndex = index;
            }
        });

    }
}
