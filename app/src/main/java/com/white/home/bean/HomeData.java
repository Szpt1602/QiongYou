package com.white.home.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class HomeData {


    /**
     * msg_switch : 1
     * slide : []
     * bar : []
     * promo : []
     * hot_topic : []
     * ptype_icon : []
     * head_slide : {}
     * gears : []
     * hover_ad : []
     * welcome_ad : []
     * promot_title : 当季热门
     * second_ad : []
     * search : {}
     * user_info : {}
     */

    private int msg_switch;
    private HeadSlideBean head_slide;
    private String promot_title;
    private List<HomeDetail> slide;
    private List<HomeDetail> bar;
    private List<HomeDetail> promo;
    private List<HomeDetail> hot_topic;
    private List<HomeDetail> ptype_icon;
    private List<HomeDetail> gears;
    private List<HomeDetail> hover_ad;
    private List<HomeDetail> welcome_ad;
    private List<HomeDetail> second_ad;

    public static HomeData objectFromData(String str) {

        return new Gson().fromJson(str, HomeData.class);
    }

    public static List<HomeData> arrayHomeDataFromData(String str) {

        Type listType = new TypeToken<ArrayList<HomeData>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getMsg_switch() {
        return msg_switch;
    }

    public void setMsg_switch(int msg_switch) {
        this.msg_switch = msg_switch;
    }

    public HeadSlideBean getHead_slide() {
        return head_slide;
    }

    public void setHead_slide(HeadSlideBean head_slide) {
        this.head_slide = head_slide;
    }

    public String getPromot_title() {
        return promot_title;
    }

    public void setPromot_title(String promot_title) {
        this.promot_title = promot_title;
    }

    public List<HomeDetail> getSlide() {
        return slide;
    }

    public void setSlide(List<HomeDetail> slide) {
        this.slide = slide;
    }

    public List<HomeDetail> getBar() {
        return bar;
    }

    public void setBar(List<HomeDetail> bar) {
        this.bar = bar;
    }

    public List<HomeDetail> getPromo() {
        return promo;
    }

    public void setPromo(List<HomeDetail> promo) {
        this.promo = promo;
    }

    public List<HomeDetail> getHot_topic() {
        return hot_topic;
    }

    public void setHot_topic(List<HomeDetail> hot_topic) {
        this.hot_topic = hot_topic;
    }

    public List<HomeDetail> getPtype_icon() {
        return ptype_icon;
    }

    public void setPtype_icon(List<HomeDetail> ptype_icon) {
        this.ptype_icon = ptype_icon;
    }

    public List<HomeDetail> getGears() {
        return gears;
    }

    public void setGears(List<HomeDetail> gears) {
        this.gears = gears;
    }

    public List<HomeDetail> getHover_ad() {
        return hover_ad;
    }

    public void setHover_ad(List<HomeDetail> hover_ad) {
        this.hover_ad = hover_ad;
    }

    public List<HomeDetail> getWelcome_ad() {
        return welcome_ad;
    }

    public void setWelcome_ad(List<HomeDetail> welcome_ad) {
        this.welcome_ad = welcome_ad;
    }

    public List<HomeDetail> getSecond_ad() {
        return second_ad;
    }

    public void setSecond_ad(List<HomeDetail> second_ad) {
        this.second_ad = second_ad;
    }

    public static class HeadSlideBean {


        /**
         * count : 2
         * slide_data : []
         */

        private int count;
        private List<HomeDetail> slide_data;


        public static HeadSlideBean objectFromData(String str) {

            return new Gson().fromJson(str, HeadSlideBean.class);
        }

        public static List<HeadSlideBean> arrayHeadSlideBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<HeadSlideBean>>() {

            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<HomeDetail> getSlide_data() {
            return slide_data;
        }

        public void setSlide_data(List<HomeDetail> slide_data) {
            this.slide_data = slide_data;
        }
    }
}
