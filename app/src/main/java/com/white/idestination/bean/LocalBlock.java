package com.white.idestination.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class LocalBlock {

    /**
     * name : 景点门票
     * url : lastminute://filter?country_id%3D11%26city_id%3D50%26continent_id%3D%26departure%3D%26times%3D%26product_type%3D2377%2C2381%26country_name%3D%E4%B8%AD%E5%9B%BD%26city_name%3D%E9%A6%99%E6%B8%AF%26product_type_name%3D%E6%99%AF%E7%82%B9%E9%97%A8%E7%A5%A8
     * cover : http://pic.qyer.com/public/lmapp/destinfo_conf/2016/05/24/14640608909881
     */

    private String name;
    private String url;
    private String cover;

    public static LocalBlock objectFromData(String str) {

        return new Gson().fromJson(str, LocalBlock.class);
    }

    public static List<LocalBlock> arrayLocalBlockFromData(String str) {

        Type listType = new TypeToken<ArrayList<LocalBlock>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
