package com.white.localleisure.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class LocalItemJson implements Parcelable {


    /**
     * id : 75810
     * productType : 2410
     * title : 【City Walk】京都NI WALK— 探秘祇园东山半日游
     * pic : http://pic.qyer.com/public/supplier/jd/2016/05/12/14630452849198/600x400
     * price : <em>228</em>元起
     * booktype : 1
     * firstpay_end_time : 2145888000
     * list_price : 480
     * lastminute_des : 4.8折
     * url : http://m.qyer.com/z/deal/75810/?source=app2&client_id=qyer_discount_androi&track_app_version=1.9.8&track_deviceid=000000000000000
     * departureTime : 2016/06-2016/06
     * sale_count : 25
     * cate_short_name : 日游体验
     * city_name : 京都
     * tag_txt :
     * ra_n_model : visa_page_recommend
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
    private String sale_count;
    private String cate_short_name;
    private String city_name;
    private String tag_txt;
    private String ra_n_model;
    /**
     * catename : 接送机服务
     * name : transport
     * icon : http://pic.qyer.com/public/lastmin/config/2015/10/17/14450612687531
     * open_type : 6
     */

    private String catename;
    private String name;
    private String icon;
    private int open_type;

    public LocalItemJson(Parcel in) {
        id = in.readString();
        productType = in.readString();
        title = in.readString();
        pic = in.readString();
        price = in.readString();
        booktype = in.readString();
        firstpay_end_time = in.readString();
        list_price = in.readString();
        lastminute_des = in.readString();
        url = in.readString();
        departureTime = in.readString();
        sale_count = in.readString();
        cate_short_name = in.readString();
        city_name = in.readString();
        tag_txt = in.readString();
        ra_n_model = in.readString();
        catename = in.readString();
        name = in.readString();
        icon = in.readString();
        open_type = in.readInt();
    }

    public static final Creator<LocalItemJson> CREATOR = new Creator<LocalItemJson>() {

        @Override
        public LocalItemJson createFromParcel(Parcel in) {
            return new LocalItemJson(in);
        }

        @Override
        public LocalItemJson[] newArray(int size) {
            return new LocalItemJson[size];
        }
    };

    public LocalItemJson() {

    }

    public static LocalItemJson objectFromData(String str) {

        return new Gson().fromJson(str, LocalItemJson.class);
    }

    public static List<LocalItemJson> arrayLocalItemFromData(String str) {

        Type listType = new TypeToken<ArrayList<LocalItemJson>>() {

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

    public String getRa_n_model() {
        return ra_n_model;
    }

    public void setRa_n_model(String ra_n_model) {
        this.ra_n_model = ra_n_model;
    }

    public String getCatename() {
        return catename;
    }

    public void setCatename(String catename) {
        this.catename = catename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getOpen_type() {
        return open_type;
    }

    public void setOpen_type(int open_type) {
        this.open_type = open_type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(productType);
        dest.writeString(title);
        dest.writeString(pic);
        dest.writeString(price);
        dest.writeString(booktype);
        dest.writeString(firstpay_end_time);
        dest.writeString(list_price);
        dest.writeString(lastminute_des);
        dest.writeString(url);
        dest.writeString(departureTime);
        dest.writeString(sale_count);
        dest.writeString(cate_short_name);
        dest.writeString(city_name);
        dest.writeString(tag_txt);
        dest.writeString(ra_n_model);
        dest.writeString(catename);
        dest.writeString(name);
        dest.writeString(icon);
        dest.writeInt(open_type);
    }
}
