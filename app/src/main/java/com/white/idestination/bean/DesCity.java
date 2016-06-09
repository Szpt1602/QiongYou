package com.white.idestination.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class DesCity {

    /**
     * name : 香港
     * city_id : 50
     * country_id : 11
     * open_type : 7
     * pic : http://pic3.qyer.com/album/user/370/89/Qk5VShMOaA/index?imageView/1/w/339/h/226
     * name_en : Hong Kong
     */

    private String name;
    private String city_id;
    private String country_id;
    private int open_type;
    private String pic;
    private String name_en;

    public static DesCity objectFromData(String str) {

        return new Gson().fromJson(str, DesCity.class);
    }

    public static List<DesCity> arrayDesCityFromData(String str) {

        Type listType = new TypeToken<ArrayList<DesCity>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public int getOpen_type() {
        return open_type;
    }

    public void setOpen_type(int open_type) {
        this.open_type = open_type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public static class OpenType {


    }

}
