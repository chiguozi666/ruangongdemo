package com.mingyuan.bangbang.pojo;

import java.math.BigDecimal;
import java.sql.Time;

public class OrderInfo {
    private int oId;
    private String publishUserid;
    private String receiveUserid;
    private String oTitle;
    private String oContent;
    private String oPhotourl;
    private BigDecimal oMoney;
    private Time oEndtime;
    private Time oFintime;
    private Time oRequiretime;
    private String locate;
    public static OrderInfo getTestInstance(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPublishUserid("发送者id");
        orderInfo.setReceiveUserid("接收者id");
        orderInfo.setoTitle("我是标题");
        orderInfo.setoContent("我是内容");
        orderInfo.setoPhotourl("www.xxxx.com");
        orderInfo.setoMoney(new BigDecimal(5.20));
        orderInfo.setoEndtime(new Time(System.currentTimeMillis()));
        orderInfo.setoFintime(new Time(System.currentTimeMillis()));
        orderInfo.setoRequiretime(new Time(System.currentTimeMillis()));
        orderInfo.setLocate("二饭");
        return orderInfo;
    }
    public OrderInfo(){}

    public OrderInfo(int oId, String publishUserid, String receiveUserid, String oTitle, String oContent, String oPhotourl, BigDecimal oMoney, Time oEndtime, Time oFintime, Time oRequiretime, String locate) {
        this.oId = oId;
        this.publishUserid = publishUserid;
        this.receiveUserid = receiveUserid;
        this.oTitle = oTitle;
        this.oContent = oContent;
        this.oPhotourl = oPhotourl;
        this.oMoney = oMoney;
        this.oEndtime = oEndtime;
        this.oFintime = oFintime;
        this.oRequiretime = oRequiretime;
        this.locate = locate;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getPublishUserid() {
        return publishUserid;
    }

    public void setPublishUserid(String publishUserid) {
        this.publishUserid = publishUserid;
    }

    public String getReceiveUserid() {
        return receiveUserid;
    }

    public void setReceiveUserid(String receiveUserid) {
        this.receiveUserid = receiveUserid;
    }

    public String getoTitle() {
        return oTitle;
    }

    public void setoTitle(String oTitle) {
        this.oTitle = oTitle;
    }

    public String getoContent() {
        return oContent;
    }

    public void setoContent(String oContent) {
        this.oContent = oContent;
    }

    public String getoPhotourl() {
        return oPhotourl;
    }

    public void setoPhotourl(String oPhotourl) {
        this.oPhotourl = oPhotourl;
    }

    public BigDecimal getoMoney() {
        return oMoney;
    }

    public void setoMoney(BigDecimal oMoney) {
        this.oMoney = oMoney;
    }

    public Time getoEndtime() {
        return oEndtime;
    }

    public void setoEndtime(Time oEndtime) {
        this.oEndtime = oEndtime;
    }

    public Time getoFintime() {
        return oFintime;
    }

    public void setoFintime(Time oFintime) {
        this.oFintime = oFintime;
    }

    public Time getoRequiretime() {
        return oRequiretime;
    }

    public void setoRequiretime(Time oRequiretime) {
        this.oRequiretime = oRequiretime;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oId=" + oId +
                ", publishUserid='" + publishUserid + '\'' +
                ", receiveUserid='" + receiveUserid + '\'' +
                ", oTitle='" + oTitle + '\'' +
                ", oContent='" + oContent + '\'' +
                ", oPhotourl='" + oPhotourl + '\'' +
                ", oMoney=" + oMoney +
                ", oEndtime=" + oEndtime +
                ", oFintime=" + oFintime +
                ", oRequiretime=" + oRequiretime +
                ", locate='" + locate + '\'' +
                '}';
    }
}
