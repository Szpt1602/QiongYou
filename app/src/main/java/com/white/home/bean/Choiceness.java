package com.white.home.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/8.
 */
public class Choiceness {

    /**
     * id : 54683
     * productType : 1016
     * title : 【端午特价】上海直飞东京5天往返含税机票（2人出行赠WIFI）
     * pic : http://pic.qyer.com/public/lastmin/lastminute/2016/05/26/14642443338643/600x400
     * price : <em>1499</em>元起
     * booktype : 1
     * firstpay_end_time : 1466870400
     * list_price : 2999
     * lastminute_des : 5折
     * url : http://m.qyer.com/z/deal/54683/?source=app2&client_id=qyer_discount_androi&track_app_version=1.9.8&track_deviceid=865586022953519&ra_model=recommend
     * departureTime : 2016/05-2016/06
     * sale_count : 875
     * cate_short_name : 机票
     * city_name : 东京
     * ra_n_model : visa_page_recommend
     * tag_txt : 下单立减300
     * ptype_icon : http://pic.qyer.com/public/lmapp/category/2016/05/12/14630207556270
     */

    private String id;
    private String productType;
    private String title;
    private String pic;
    private String price;
    private String booktype;
    private String firstpay_end_time;
    private String list_price;
    private String lastminute_des;
    private String url;
    private String departureTime;
    private int sale_count;
    private String cate_short_name;
    private String city_name;
    private String ra_n_model;
    private String tag_txt;
    private String ptype_icon;

    public static Choiceness objectFromData(String str) {

        return new Gson().fromJson(str, Choiceness.class);
    }

    public static List<Choiceness> arrayChoicenessFromData(String str) {

        Type listType = new TypeToken<ArrayList<Choiceness>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getFirstpay_end_time() {
        return firstpay_end_time;
    }

    public void setFirstpay_end_time(String firstpay_end_time) {
        this.firstpay_end_time = firstpay_end_time;
    }

    public String getList_price() {
        return list_price;
    }

    public void setList_price(String list_price) {
        this.list_price = list_price;
    }

    public String getLastminute_des() {
        return lastminute_des;
    }

    public void setLastminute_des(String lastminute_des) {
        this.lastminute_des = lastminute_des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getSale_count() {
        return sale_count;
    }

    public void setSale_count(int sale_count) {
        this.sale_count = sale_count;
    }

    public String getCate_short_name() {
        return cate_short_name;
    }

    public void setCate_short_name(String cate_short_name) {
        this.cate_short_name = cate_short_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getRa_n_model() {
        return ra_n_model;
    }

    public void setRa_n_model(String ra_n_model) {
        this.ra_n_model = ra_n_model;
    }

    public String getTag_txt() {
        return tag_txt;
    }

    public void setTag_txt(String tag_txt) {
        this.tag_txt = tag_txt;
    }

    public String getPtype_icon() {
        return ptype_icon;
    }

    public void setPtype_icon(String ptype_icon) {
        this.ptype_icon = ptype_icon;
    }
}
