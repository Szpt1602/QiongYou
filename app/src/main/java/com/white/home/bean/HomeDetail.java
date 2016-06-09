package com.white.home.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A8 on 2016/6/4.
 */
public class HomeDetail {


    /**
     * _id :
     * id :
     * open_type : 3
     * title : 大促返场
     * url : http://m.qyer.com/z/zt/dcfc2016&source=app2&campaign=zkapp&category=slide_dcfc2016/?client_id=qyer_discount_androi&track_app_version=1.9.8&track_deviceid=865586022953519&ra_model=index_ad
     * img : http://pic.qyer.com/public/lmapp/op_conf/2016/05/23/14639826623165?imageMogr2/thumbnail/!750x375r
     * type : topic
     * ra_n_model : index_ad
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
     * name : 自由行
     * enname :
     * icon : http://pic.qyer.com/public/lmapp/category/2016/05/06/14625235646061
     */

    private String name;
    private String enname;
    private String icon;
    /**
     * ptype_id : 2410
     * bgc : #F0AA64
     */

    private int ptype_id;
    private String bgc;
    /**
     * cover : http://pic.qyer.com/public/lmapp/op_conf/2016/06/02/14648615991672?imageMogr2/thumbnail/!750x375r
     */

    private String cover;


    public static HomeDetail objectFromData(String str) {

        return new Gson().fromJson(str, HomeDetail.class);
    }

    public static List<HomeDetail> arrayHomeDataDetailFromData(String str) {

        Type listType = new TypeToken<ArrayList<HomeDetail>>() {

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

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getPtype_id() {
        return ptype_id;
    }

    public void setPtype_id(int ptype_id) {
        this.ptype_id = ptype_id;
    }

    public String getBgc() {
        return bgc;
    }

    public void setBgc(String bgc) {
        this.bgc = bgc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
