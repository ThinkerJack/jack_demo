package com.example.model;

/**
 * Copyright 2021 bejson.com
 */
import java.util.Date;

/**
 * Auto-generated: 2021-06-30 14:57:23
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Token {

    private String access_token;
    private Date at_expired_at;
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    public String getAccess_token() {
        return access_token;
    }

    public void setAt_expired_at(Date at_expired_at) {
        this.at_expired_at = at_expired_at;
    }
    public Date getAt_expired_at() {
        return at_expired_at;
    }

}