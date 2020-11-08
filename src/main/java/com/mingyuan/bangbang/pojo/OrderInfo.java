package com.mingyuan.bangbang.pojo;

import java.math.BigDecimal;
import java.sql.Time;

public class OrderInfo {
    int o_id;
    String publish_userid;
    String receive_userid;
    String o_title;
    String o_content;
    String o_photourl;
    BigDecimal o_money;
    Time o_endtime;
    Time o_fintime;
    Time o_requiretime;
    String locate;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getPublish_userid() {
        return publish_userid;
    }

    public void setPublish_userid(String publish_userid) {
        this.publish_userid = publish_userid;
    }

    public String getReceive_userid() {
        return receive_userid;
    }

    public void setReceive_userid(String receive_userid) {
        this.receive_userid = receive_userid;
    }

    public String getO_title() {
        return o_title;
    }

    public void setO_title(String o_title) {
        this.o_title = o_title;
    }

    public String getO_content() {
        return o_content;
    }

    public void setO_content(String o_content) {
        this.o_content = o_content;
    }

    public String getO_photourl() {
        return o_photourl;
    }

    public void setO_photourl(String o_photourl) {
        this.o_photourl = o_photourl;
    }

    public BigDecimal getO_money() {
        return o_money;
    }

    public void setO_money(BigDecimal o_money) {
        this.o_money = o_money;
    }

    public Time getO_endtime() {
        return o_endtime;
    }

    public void setO_endtime(Time o_endtime) {
        this.o_endtime = o_endtime;
    }

    public Time getO_fintime() {
        return o_fintime;
    }

    public void setO_fintime(Time o_fintime) {
        this.o_fintime = o_fintime;
    }

    public Time getO_requiretime() {
        return o_requiretime;
    }

    public void setO_requiretime(Time o_requiretime) {
        this.o_requiretime = o_requiretime;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }
}
