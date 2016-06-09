package com.white.my.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.white.R;

/**
 * Created by Exp on 2016/6/8.
 */
public class Fragment_login_message_login extends RelativeLayout {

    public Fragment_login_message_login(Context context) {
        super(context);
        inflate(context, R.layout.fragment_login_message_login,this);
    }

    public Fragment_login_message_login(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.fragment_login_message_login,this);
    }
}
