package com.white.home.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.white.other.utils.Constant;
import com.white.other.utils.HttpUtil;

/**
 * Created by A8 on 2016/6/4.
 */
public class HomeHttpUtil {

    private static final String HOME_DATA_URL = Constant.HOME_URL;
    private static Bitmap bitmap;

    public static void getHomeData(HttpUtil.RequestCallback callback) {
        HttpUtil.doGet(HOME_DATA_URL, callback);

    }

    private static final String HOME_CHOICENESS_URL = Constant.HOME_CHOICENESS_DATA;

    public static void getHomeChoicenessData(HttpUtil.RequestCallback callback, int page, int size) {
        HttpUtil.doGet(HOME_CHOICENESS_URL + "page=" + page + "&pageSize=" + size, callback);
    }

    public static void loadPic(final String picUrl, final HttpUtil.RequestCallback callback) {
        bitmap = null;

        new AsyncTask<Void, Void, byte[]>() {

            @Override
            protected void onPostExecute(byte[] bytes) {
                bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                callback.success(bitmap);
            }

            @Override
            protected byte[] doInBackground(Void... params) {
                return HttpUtil.getBytes(picUrl);
            }
        }.execute();

    }

}
