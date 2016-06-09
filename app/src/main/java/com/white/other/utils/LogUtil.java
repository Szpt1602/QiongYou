package com.white.other.utils;

import android.util.Log;

/**
 * Created by A8 on 2016/6/3.
 */
public class LogUtil {

    private static boolean debug = true;

    public static void e(String text) {
        if (debug) {
            Log.e("LogUtil", text);
        }
    }

    public static void w(String text) {
        if (debug) {
            Log.w("LogUtil", text);
        }
    }

    public static void i(String text) {
        if (debug) {
            Log.i("LogUtil", text);
        }
    }

    public static void d(String text) {
        if (debug) {
            Log.d("LogUtil", text);
        }
    }

    public static void v(String text) {
        if (debug) {
            Log.v("LogUtil", text);
        }
    }

}
