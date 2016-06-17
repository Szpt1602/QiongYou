package com.white.other.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * 获取一个普通的图片属性
 * Created by Administrator on 2016/5/19.
 */
public class ImageUtil {

    public static void setTextDrawableForUrl(final String url, final HttpUtil.RequestCallback callback) {
        new AsyncTask<Void, Void, byte[]>() {

            @Override
            protected byte[] doInBackground(Void... params) {
                return HttpUtil.getBytes(url);
            }

            @Override
            protected void onPostExecute(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                BitmapDrawable drawable = new BitmapDrawable(bitmap);
                callback.success(drawable);
            }
        }.execute();
    }

    public static DisplayImageOptions getNormalImageOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        return options;
    }

    /**
     * 获取一个圆角图片属性
     *
     * @return
     */
    public static DisplayImageOptions getCircleImageOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new CircleBitmapDisplayer())//设置圆型显示
                //圆角
                //.displayer(new RoundedBitmapDisplayer(10))//设置圆角显示
                .build();

        return options;
    }

    /**
     * 获取一个圆角图片属性
     *
     * @return
     */
    public static DisplayImageOptions getCircleImageOptions(int i) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                //圆角
                .displayer(new RoundedBitmapDisplayer(i))//设置圆角显示
                .build();

        return options;
    }

}
