package com.white.idestination.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class DesRecommend {

    /**
     * name : 热门
     * destinations : []
     */

    private String name;
    private List<DesCity> destinations;

    public static DesRecommend objectFromData(String str) {

        return new Gson().fromJson(str, DesRecommend.class);
    }

    public static List<DesRecommend> arrayDesRecommendFromData(String str) {

        Type listType = new TypeToken<ArrayList<DesRecommend>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DesCity> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DesCity> destinations) {
        this.destinations = destinations;
    }
}
