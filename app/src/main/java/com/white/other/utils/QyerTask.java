package com.white.other.utils;

import android.os.AsyncTask;

/**
 * Void 传进的参数
 * Void 进度
 * Object 结果
 * Created by Administrator on 2016/5/19.
 */
public class QyerTask extends AsyncTask<Void, Void, Object> {

    private IRequest request;

    private IRequestCallback callback;

    public QyerTask(IRequest request, IRequestCallback callback) {
        if (request == null || callback == null) {
            throw new NullPointerException(
                    "IRequest or IRequestCallback can not be null...");
        }
        this.request = request;
        this.callback = callback;
    }

    @Override
    protected Object doInBackground(Void... params) {
        return request.doRequest();
    }

    @Override
    protected void onPostExecute(Object o) {
        // 如果0（请求的结果）==空的话，那么表示请求失败了，那么需要把错误信息返回到界面
        if (o == null) {
            callback.error("请求失败了!!!");
        } else {

            // 如果不等于null表示请求成功了，那么把结果返回到界面
            callback.success(o);
        }
    }

    /**
     * 请求接口
     */
    public interface IRequest {

        /**
         * 执行请求
         */
        Object doRequest();
    }

    /**
     * 请求回调接口
     */
    public interface IRequestCallback {

        /**
         * 请求成功回调
         *
         * @param obj 请求结果
         */
        void success(Object obj);

        /**
         * 请求失败回调
         *
         * @param msg 错误信息
         */
        void error(String msg);
    }

    /**
     * 下载监听
     */
    public interface IDownLoaderListener {

        /**
         * 开始下载
         */
        void start();

        /**
         * 下载完成
         */
        void completed();

        /**
         * 更新进度
         *
         * @param progress
         */
        void updateProgress(float progress);

        /**
         * 下载失败
         */
        void error();

    }
}