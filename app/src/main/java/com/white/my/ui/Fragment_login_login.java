package com.white.my.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.white.R;

/**
 * Created by Exp on 2016/6/8.
 */
public class Fragment_login_login extends RelativeLayout {

    private Button btn;

    public Fragment_login_login(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.fragment_login_login,this);
    }

    public Fragment_login_login(Context context) {
        super(context);
        inflate(context, R.layout.fragment_login_login,this);

        btn = (Button) findViewById(R.id.login_activity_login_btn);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "请填写完整",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
