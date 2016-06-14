package com.white.other.utils;

import android.app.Activity;
import android.content.Intent;

import com.white.localleisure.ui.CityActivity;
import com.white.localleisure.ui.VisaActivity;
import com.white.my.ui.LoginActivity;

/**
 * Created by Exp on 2016/6/8.
 */
public class JumpManager {

    private static Intent intent;

    /**
     * 跳到登录页面
     * @param activity
     */
    public static void jumpToLoginActivity(Activity activity){
        intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转选择城市页面
     * @param activity
     */
    public static void jumpToCityActivity(Activity activity){
        intent=new Intent(activity, CityActivity.class);
        activity.startActivity(intent);
    }
    /**
     * 跳转签证页面
     * @param activity
     */
    public static void jumpToVisaActivity(Activity activity){
        intent=new Intent(activity, VisaActivity.class);
        activity.startActivity(intent);
    }



}
