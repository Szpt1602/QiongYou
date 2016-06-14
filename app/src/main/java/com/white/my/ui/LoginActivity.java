package com.white.my.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.white.R;
import com.white.my.adatper.Login_Vp_Adapter;
import com.white.other.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Exp on 2016/6/3.
 */
public class LoginActivity extends BaseActivity {

    private ImageView back_iv;
    private TextView register;
    private RadioButton login,message_login;
    private ViewPager vp;
    private  List<View> list;
    private RadioGroup rg;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvents() {

        back_iv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
                LoginActivity.this.finish();
//                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                switch (position){
                    case 0:
                        rg.check(R.id.login_activity_btn1);
                        break;
                    case 1:
                        rg.check(R.id.login_activity_btn2);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.login_activity_btn1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.login_activity_btn2:
                        vp.setCurrentItem(1);
                        break;
                }
            }
        });


    }

    @Override
    protected void initViews() {
        back_iv = (ImageView) findViewById(R.id.login_activity_out);
        register = (TextView) findViewById(R.id.login_activity_register);
        login = (RadioButton) findViewById(R.id.login_activity_btn1);
        message_login = (RadioButton) findViewById(R.id.login_activity_btn2);

        rg = (RadioGroup) findViewById(R.id.login_activity_rg);
        vp = (ViewPager) findViewById(R.id.activity_login_vp);
        Fragment_login_login fragment_login_login = new Fragment_login_login(this);
        Fragment_login_message_login fragment_login_message_login = new Fragment_login_message_login(this);
        list = new ArrayList<>();
        list.add(fragment_login_login);
        list.add(fragment_login_message_login);
        Login_Vp_Adapter adapter = new Login_Vp_Adapter(list);
        vp.setAdapter(adapter);
    }



}
