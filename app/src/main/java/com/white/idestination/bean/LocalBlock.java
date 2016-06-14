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
     * id : 57
     * name : 胡志明市
     * enname : Ho Chi Minh City
     * type : city
     * cover : http://pic2.qyer.com/album/138/fc/1877446/index/600x400
     * url : lastminute://filter?country_id%3D216%26city_id%3D57%26continent_id%3D%26departure%3D%26times%3D%26product_type%3D%26country_name%3D%E8%B6%8A%E5%8D%97%26city_name%3D%E8%83%A1%E5%BF%97%E6%98%8E%E5%B8%82%26product_type_name%3D%E5%85%A8%E9%83%A8
     */

    private String id;
    private String name;
    private String enname;
    private String type;
    private String cover;
    private String url;

    public static LocalBlock objectFromData(String str) {

        return new Gson().fromJson(str, LocalBlock.class);
    }

    public static List<LocalBlock> arrayLocalBlockFromData(String str) {

        Type listType = new TypeToken<ArrayList<LocalBlock>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
