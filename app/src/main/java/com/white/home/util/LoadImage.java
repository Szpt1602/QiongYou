package com.white.home.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by A8 on 2016/6/4.
 */
public class LoadImage {

    public static void SaveImageFromHttp(File dir, String url) {

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                if (!dir.getParentFile().exists()) {
                    throw new FileNotFoundException("没有该文件夹");
                }
                File file = new File(dir, url);
                FileOutputStream fos = new FileOutputStream(file);

                int len;
                byte[] b = new byte[1024];
                while ((len = is.read(b)) != -1) {
                    fos.write(b, 0, len);
                }

                fos.flush();
                fos.close();
                is.close();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
