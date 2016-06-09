package com.white.idestination.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Des_City_Name1 {

    /**
     * cover : http://pic2.qyer.com/album/user/370/89/Qk5VShMOaA/index/600x400
     * name : 香港
     * enname : Hong Kong
     * local_block : []
     * ptype_block : []
     */

    private String cover;
    private String name;
    private String enname;
    private List<LocalBlock> local_block;
    private List<PtypeBlock> ptype_block;

    public static Des_City_Name1 objectFromData(String str) {

        return new Gson().fromJson(str, Des_City_Name1.class);
    }

    public static List<Des_City_Name1> arrayDes_City_Name1FromData(String str) {

        Type listType = new TypeToken<ArrayList<Des_City_Name1>>() {

        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public List<LocalBlock> getLocal_block() {
        return local_block;
    }

    public void setLocal_block(List<LocalBlock> local_block) {
        this.local_block = local_block;
    }

    public List<PtypeBlock> getPtype_block() {
        return ptype_block;
    }

    public void setPtype_block(List<PtypeBlock> ptype_block) {
        this.ptype_block = ptype_block;
    }
}
