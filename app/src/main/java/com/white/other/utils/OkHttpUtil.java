package com.white.other.utils;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2016/5/26.
 */
public class OkHttpUtil {

    enum RequestType {
        GET,

        POST

    }

    private static Handler handler = new Handler();


    private static OkHttpClient client;

    private static OkHttpClient getOkHttpClientInstance() {
        if (client == null) {
            synchronized (OkHttpUtil.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }

        return client;
    }

    /**
     * Post请求
     *
     * @param url 地址
     * @param body 参数
     * @param callback 回调
     */
    public static void doPost(String url, RequestBody body,
                              final QyerTask.IRequestCallback callback) {
        doRequest(url, RequestType.POST, body, callback);
    }

    /**
     * Get请求
     *
     * @param url 地址
     * @param callback 回调
     */
    public static void doGet(String url, final QyerTask.IRequestCallback callback) {
        doRequest(url, RequestType.GET, null, callback);
    }

    /**
     * 请求
     *
     * @param url 地址
     * @param body 参数
     * @param callback 回调
     */
    private static void doRequest(String url, final RequestType type,
                                  RequestBody body, final QyerTask.IRequestCallback callback) {

        LogUtil.d("url = " + url);

        // 创建一个请求客户端
        getOkHttpClientInstance();

        // 创建一个请求
        Request request = null;
        if (type == RequestType.GET) {
            request = new Request.Builder().url(url)// 请求地址
                    .get()// GET请求
                    .build();// 创建request
        } else {
            request = new Request.Builder().url(url).post(body).build();
        }

        // 相当于我们之前写的 QyerTask
        Call call = client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e("onFailure ... ");

                if (callback != null) {
                    callback.error(e.getMessage());
                }
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                // 获取返回体
                ResponseBody body = response.body();

                // 获取字符流
                Reader reader = body.charStream();
                // 创建一个读取缓冲流
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line = null;
                StringBuffer resultBuffer = new StringBuffer();
                // 循环读取一行
                while ((line = bufferedReader.readLine()) != null) {
                    // 拼接结果
                    resultBuffer.append(line);
                }

                String result = resultBuffer.toString();

                LogUtil.w("result = " + result);
                if (callback != null) {

                    callback.success(result);
                }

                reader.close();
                bufferedReader.close();
            }
        });
    }

    public static void downLoad(String url, final File dir, final String rename,
                                final QyerTask.IDownLoaderListener listener) {
        client = new OkHttpClient();

        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e("请求失败");
                if (listener != null) {
                    listener.error();
                }
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                ResponseBody body = response.body();

                InputStream inputStream = body.byteStream();

                int read = -1;

                int hasRead = 0;

                byte[] buff = new byte[512];
                // 文件的大小
                long lenght = body.contentLength();

                // 目标文件
                File target = new File(dir, rename);
                // 创建输出流
                FileOutputStream fos = new FileOutputStream(target);
                if (listener != null) {
                    listener.start();
                }
                // 循环读取
                while ((read = inputStream.read(buff)) != -1) {
                    // 写到文件里
                    fos.write(buff, 0, read);

                    // 计算下载进度
                    hasRead += read;

                    float per = 100.0f * hasRead / lenght;

                    LogUtil.d("per = " + per);

                    if (listener != null) {
                        listener.updateProgress(per);
                    }
                }

                LogUtil.e("下载完成!");
                if (listener != null) {
                    listener.completed();
                }

                inputStream.close();
                fos.close();
            }
        });
    }
}
