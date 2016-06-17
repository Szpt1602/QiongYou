package com.white.other.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.white.localleisure.ui.CityActivity;
import com.white.localleisure.ui.VisaActivity;
import com.white.my.ui.LoginActivity;
import com.white.other.ui.activity.ProductActivity;
import com.white.other.ui.activity.WebBuyActivity;
import com.white.other.ui.activity.WebNormalActivity;

/**
 * Created by Exp on 2016/6/8.
 */
public class JumpManager {

    private static Intent intent;

    /**
     * 跳到登录页面
     *
     * @param activity
     */
    public static void jumpToLoginActivity(Activity activity) {
        intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转选择城市页面
     *
     * @param activity
     */
    public static void jumpToCityActivity(Activity activity) {
        intent = new Intent(activity, CityActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转签证页面
     *
     * @param activity
     */
    public static void jumpToVisaActivity(Activity activity) {
        intent = new Intent(activity, VisaActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到WebNormalActivity
     */
    public static void jumpToWebNormalActivity(Context context, String url) {
        intent = new Intent(context, WebNormalActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    /**
     * 跳转到WebBuyActivity
     */
    public static void jumpToWebBuyActivity(Context context, String url) {
        intent = new Intent(context, WebBuyActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    public static void jumpToProductActivity(Context context, String name,int typeNum) {
        intent = new Intent(context, ProductActivity.class);
        intent.putExtra("type", name);
        intent.putExtra("typeNum", typeNum);
        context.startActivity(intent);
    }


}
