package com.white.idestination.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class PtypeBlock {

    /**
     * name : 机酒自由行
     * cover : http://pic.qyer.com/public/lmapp/destinfo_conf/2016/05/27/14643188975840
     * url : lastminute://filter?country_id%3D11%26city_id%3D50%26continent_id%3D%26departure%3D%26times%3D%26product_type%3D1016%2C1018%2C1020%26country_name%3D%E4%B8%AD%E5%9B%BD%26city_name%3D%E9%A6%99%E6%B8%AF%26product_type_name%3D%E6%9C%BA%E9%85%92%E8%87%AA%E7%94%B1%E8%A1%8C
     */

    private String name;
    private String cover;
    private String url;

    public static PtypeBlock objectFromData(String str) {

        return new Gson().fromJson(str, PtypeBlock.class);
    }

    public static List<PtypeBlock> arrayPtypeBlockFromData(String str) {

        Type listType = new TypeToken<ArrayList<PtypeBlock>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
