package com.white.home.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/8.
 */
public class HomeBottom {

    /**
     * status : 1
     * info :
     * times : 0
     * data : []
     * ra_referer : choiceness
     */

    private int status;
    private String info;
    private int times;
    private String ra_referer;
    private List<Choiceness> data;

    public static HomeBottom objectFromData(String str) {

        return new Gson().fromJson(str, HomeBottom.class);
    }

    public static List<HomeBottom> arrayHomeBottomFromData(String str) {

        Type listType = new TypeToken<ArrayList<HomeBottom>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getRa_referer() {
        return ra_referer;
    }

    public void setRa_referer(String ra_referer) {
        this.ra_referer = ra_referer;
    }

    public List<Choiceness> getData() {
        return data;
    }

    public void setData(List<Choiceness> data) {
        this.data = data;
    }
}
