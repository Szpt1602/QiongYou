package com.white.localleisure.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class LocalVisaJson implements Parcelable{


    /**
     * _id :
     * id :
     * open_type : 3
     * title : 签证soeasy
     * url : http://m.qyer.com/z/zt/qzsoeasy/?source=app&campaign=zkapp&category=qzslide_qzsoeasy%2F&client_id=qyer_discount_androi&track_app_version=1.9.8&track_deviceid=000000000000000&ra_referer=app_home+HTTP%2F1.1
     * img : http://pic.qyer.com/public/lastmin/app_operation/2016/06/08/14653548526531?imageMogr2/thumbnail/!750x375r
     * type : topic
     * ra_n_model : visa_page_slide
     */

    private String _id;
    private String id;
    private String open_type;
    private String title;
    private String url;
    private String img;
    private String type;
    private String ra_n_model;
    /**
     * name : 日本
     * country_id : 14
     * pic : http://pic.qyer.com/public/lastmin/config/2016/01/14/14527643077557
     * name_en : Japan
     */

    private String name;
    private String country_id;
    private String pic;
    private String name_en;
    /**
     * productType : 1785
     * price : <em>299</em>元起
     * booktype : 1
     * firstpay_end_time : 2145888000
     * list_price : 800
     * lastminute_des : 3.7折
     * departureTime : 多日期出发
     * sale_count : 3320
     * cate_short_name : 签证
     * city_name : 日本
     * tag_txt : 下单立减20
     */

    private String productType;
    private String price;
    private String booktype;
    private String firstpay_end_time;
    private String list_price;
    private String lastminute_des;
    private String departureTime;
    private String sale_count;
    private String cate_short_name;
    private String city_name;
    private String tag_txt;

    protected LocalVisaJson(Parcel in) {
        _id = in.readString();
        id = in.readString();
        open_type = in.readString();
        title = in.readString();
        url = in.readString();
        img = in.readString();
        type = in.readString();
        ra_n_model = in.readString();
        name = in.readString();
        country_id = in.readString();
        pic = in.readString();
        name_en = in.readString();
        productType = in.readString();
        price = in.readString();
        booktype = in.readString();
        firstpay_end_time = in.readString();
        list_price = in.readString();
        lastminute_des = in.readString();
        departureTime = in.readString();
        sale_count = in.readString();
        cate_short_name = in.readString();
        city_name = in.readString();
        tag_txt = in.readString();
    }

    public static final Creator<LocalVisaJson> CREATOR = new Creator<LocalVisaJson>() {

        @Override
        public LocalVisaJson createFromParcel(Parcel in) {
            return new LocalVisaJson(in);
        }

        @Override
        public LocalVisaJson[] newArray(int size) {
            return new LocalVisaJson[size];
        }
    };

    public static LocalVisaJson objectFromData(String str) {

        return new Gson().fromJson(str, LocalVisaJson.class);
    }

    public static List<LocalVisaJson> arrayLocalVisaJsonFromData(String str) {

        Type listType = new TypeToken<ArrayList<LocalVisaJson>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpen_type() {
        return open_type;
    }

    public void setOpen_type(String open_type) {
        this.open_type = open_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRa_n_model() {
        return ra_n_model;
    }

    public void setRa_n_model(String ra_n_model) {
        this.ra_n_model = ra_n_model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getSale_count() {
        return sale_count;
    }

    public void setSale_count(String sale_count) {
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

    public String getTag_txt() {
        return tag_txt;
    }

    public void setTag_txt(String tag_txt) {
        this.tag_txt = tag_txt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(id);
        dest.writeString(open_type);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(img);
        dest.writeString(type);
        dest.writeString(ra_n_model);
        dest.writeString(name);
        dest.writeString(country_id);
        dest.writeString(pic);
        dest.writeString(name_en);
        dest.writeString(productType);
        dest.writeString(price);
        dest.writeString(booktype);
        dest.writeString(firstpay_end_time);
        dest.writeString(list_price);
        dest.writeString(lastminute_des);
        dest.writeString(departureTime);
        dest.writeString(sale_count);
        dest.writeString(cate_short_name);
        dest.writeString(city_name);
        dest.writeString(tag_txt);
    }
}
