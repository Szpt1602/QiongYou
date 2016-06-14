package com.white.other;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by A8 on 2016/6/2.
 */
public class TravelApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //获取ImageLoader默认的设置
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);
        //ImageLoader初始化操作
        ImageLoader.getInstance().init(configuration);

    }
}
