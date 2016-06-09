package com.white.other.utils;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by A8 on 2016/6/3.
 */
public class HttpUtil {

    enum RequestType {
        GET,
        POST,
        DOWNLOAD,
    }

    private static OkHttpClient client = new OkHttpClient();

    private static Handler mHandler = new Handler();

    private synchronized static OkHttpClient getInstance() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    public static void doGet(String url, RequestCallback callback) {
        doRequest(url, callback, RequestType.GET, null);
    }

    private static void doRequest(String url, final RequestCallback callback, RequestType type, RequestBody body) {
        client = getInstance();

        Request request = null;
        if (type == RequestType.GET) {
            request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
        } else if (type == RequestType.POST) {
            request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        }

        if (request == null)
            return;

        Call call = client.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e("onFailure +" + e.toString());
                if (callback != null) {
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                            callback.fail();
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                ResponseBody body = response.body();
                Reader reader = body.charStream();
                BufferedReader br = new BufferedReader(reader);
                String line;
                StringBuffer resultBuffer = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    resultBuffer.append(line);
                }

                final String result = resultBuffer.toString();

                LogUtil.d("result = " + result);

                if (callback != null) {
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                            callback.success(result);
                        }
                    });
                }
                reader.close();
                br.close();
            }
        });
    }

    public static byte[] getBytes(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                int len;
                byte[] b = new byte[1024];
                while ((len = is.read(b)) != -1) {
                    baos.write(b, 0, len);
                }

                baos.flush();
                baos.close();
                is.close();

                return baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public interface RequestCallback {

        void success(Object result);

        void fail();
    }



    public static Object doGet(String httpUrl) {
        InputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // GET请求
            conn.setRequestMethod("GET");
            // 超时时长
            conn.setConnectTimeout(5000);
            // 读取超时
            conn.setReadTimeout(5000);

            conn.connect();
            // 获取响应码
            int code = conn.getResponseCode();
            // 如果等200表示请求成功
            if (code == HttpURLConnection.HTTP_OK) {
                inputStream = conn.getInputStream();
                // 快速读取
                streamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(streamReader);

                // 创建一个结果集接收读取的内容
                StringBuffer buffer = new StringBuffer();
                String line = null;
                // 循环读取一行
                while ((line = bufferedReader.readLine()) != null) {
                    // 把读取一行的内容添加到buffer中
                    buffer.append(line);
                }
                // 最终想要的结果
                String result = buffer.toString();

                LogUtil.w("请求成功:" + result);
                return result;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (inputStream != null) {
                try {
                    inputStream.close();
                    streamReader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        LogUtil.e("请求失败!!!");
        return null;
    }

    /**
     * 执行Post请求
     *
     * @param httpUrl 请求地址
     * @param params 请求参数
     *
     * @return
     */
    public static Object doPost(String httpUrl, HashMap<String, String> params) {
        // 举例:http://zhushou.72g.com/app/gift/gift_list?
        // 把Map里面所有键值对拼接成类似于这样的字符串paltform=2&gifttype=1
        // 解析参数
        // map转化为set
        Set<Map.Entry<String, String>> set = params.entrySet();
        // 获取迭代器
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        // 开始迭代获取所有的键和值

        StringBuffer paramsBuffer = new StringBuffer();
        if (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            // 获取每一个键值对的键名
            String key = entry.getKey();
            // 把key拼接到buffer里面
            paramsBuffer.append(key);
            paramsBuffer.append("=");
            // 获取每一个键值对的值
            String value = entry.getValue();
            // 把value拼接到buffer里面
            paramsBuffer.append(value);
            paramsBuffer.append("&");
        }

        // 去掉最后面的屁股"&"
        String paramString = paramsBuffer.toString();
        paramString = paramString.substring(0, paramString.length() - 1);

        InputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // GET请求
            conn.setRequestMethod("POST");
            // 超时时长
            conn.setConnectTimeout(5000);
            // 读取超时
            conn.setReadTimeout(5000);
            // 允许使用缓存
            conn.setUseCaches(true);
            // 允许读取写入操作
            conn.setDoOutput(true);
            // 开始连接
            conn.connect();

            // 获取输出流
            outputStream = conn.getOutputStream();
            // 写入参数
            outputStream.write(paramString.getBytes());
            outputStream.flush();

            // 获取响应码
            int code = conn.getResponseCode();
            // 如果等200表示请求成功
            if (code == HttpURLConnection.HTTP_OK) {
                inputStream = conn.getInputStream();
                // 快速读取
                streamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(streamReader);

                // 创建一个结果集接收读取的内容
                StringBuffer buffer = new StringBuffer();
                String line = null;
                // 循环读取一行
                while ((line = bufferedReader.readLine()) != null) {
                    // 把读取一行的内容添加到buffer中
                    buffer.append(line);
                }
                // 最终想要的结果
                String result = buffer.toString();

                LogUtil.w("请求成功:" + result);
                return result;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (inputStream != null) {
                try {
                    inputStream.close();
                    streamReader.close();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        LogUtil.e("请求失败!!!");
        return null;
    }

    public static File downLoad(String httUrl, File dir, String fileName, QyerTask.IDownLoaderListener listener) {
        LogUtil.e("url = " + httUrl);
        InputStream ips = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL(httUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.connect();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                ips = conn.getInputStream();
                byte[] bytes = new byte[1024];
                File targetFile = new File(dir, fileName);
                fos = new FileOutputStream(targetFile);
                int len = 0;
                LogUtil.w("开始下载");
                if (listener != null) {
                    listener.start();
                }
                //获取文件的总长度
                int contentLength = conn.getContentLength();
                int hasRead = 0;
                int progress = 0;
                while ((len = ips.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                    hasRead += len;
                }
                fos.flush();

                LogUtil.w("下载成功");
                return targetFile;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ips != null) {
                try {
                    ips.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        LogUtil.e("下载失败!!!");
        return null;
    }


}
