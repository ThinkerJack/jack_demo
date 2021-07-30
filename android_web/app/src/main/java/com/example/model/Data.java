/**
 * Copyright 2021 bejson.com
 */
package com.example.model;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Auto-generated: 2021-06-30 14:57:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private String id;
    private String name;
    private int sex;
    private long reg_time;
    private Token token;
    private String signature;
    private int type;
    private List<String> photos;
    private Privacy privacy;
    private int uid;
    private int popular;
    private int be_liked;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setReg_time(long reg_time) {
        this.reg_time = reg_time;
    }

    public long getReg_time() {
        return reg_time;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setPopular(int popular) {
        this.popular = popular;
    }

    public int getPopular() {
        return popular;
    }

    public void setBe_liked(int be_liked) {
        this.be_liked = be_liked;
    }

    public int getBe_liked() {
        return be_liked;
    }

}