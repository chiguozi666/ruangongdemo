package com.mingyuan.bangbang.pojo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public class OrderVo {
    int oId;
    String o_title;
    String o_content;
    int money;
    String o_endtime;
    String  o_requiretime;
    String locate;

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getO_endtime() {
        return o_endtime;
    }

    public void setO_endtime(String o_endtime) {
        this.o_endtime = o_endtime;
    }

    public String getO_requiretime() {
        return o_requiretime;
    }

    public void setO_requiretime(String o_requiretime) {
        this.o_requiretime = o_requiretime;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Override
    public String toString() {
        return "OrderVo{" +
                "oId=" + oId +
                ", o_title='" + o_title + '\'' +
                ", o_content='" + o_content + '\'' +
                ", money=" + money +
                ", o_endtime='" + o_endtime + '\'' +
                ", o_requiretime='" + o_requiretime + '\'' +
                ", locate='" + locate + '\'' +
                '}';
    }
}
