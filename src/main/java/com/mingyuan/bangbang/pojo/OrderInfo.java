package com.mingyuan.bangbang.pojo;

import java.math.BigDecimal;

public class OrderInfo {
    public static final int START_STATE = 100;
    public static final int START_OVER_ACCEPT_TIME_STATE = 101;
    public static final int ACCEPT_RUNING_STATE = 102;
    public static final int ACCEPT_BUT_OVERTIME_STATE = 103;
    public static final int FINISH_BUT_OVERTIME_STATE= 104;
    public static final int FINISH_NORMAL_STATE = 105;
    private int oId;
    private String publishUserid;
    private String receiveUserid;
    private String oTitle;
    private String oContent;
    private String oPhotourl;
    private BigDecimal oMoney;
    private String oPublishtime;
    private String oAccepttime;
    private String oEndtime;
    private String oFintime;
    private String oRequiretime;
    private String locate;
    private int oState;
    public static OrderInfo getTestInstance(){
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setPublishUserid("发送者id");
        orderInfo.setReceiveUserid("接收者id");
        orderInfo.setoTitle("我是标题");
        orderInfo.setoContent("我是内容");
        orderInfo.setoPhotourl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1605456550520&di=53a0091a6b5050bc9bcc276bec0214b7&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg");
        orderInfo.setoMoney(new BigDecimal(5.20));
        orderInfo.setoPublishtime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setoAccepttime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setoEndtime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setoFintime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setoRequiretime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setLocate("二饭");
        orderInfo.setoState(OrderInfo.START_STATE);
        return orderInfo;
    }
    public OrderInfo(){}

    public OrderInfo(int oId, String publishUserid, String receiveUserid,
                     String oTitle, String oContent, String oPhotourl,
                     BigDecimal oMoney, String oEndtime, String oFintime, String oRequiretime,
                     String locate, int oState) {
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
        this.oState = oState;
    }

    public String getoPublishtime() {
        return oPublishtime;
    }

    public void setoPublishtime(String oPublishtime) {
        this.oPublishtime = oPublishtime;
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

    public String getoEndtime() {
        return oEndtime;
    }

    public void setoEndtime(String oEndtime) {
        this.oEndtime = oEndtime;
    }

    public String getoFintime() {
        return oFintime;
    }

    public void setoFintime(String oFintime) {
        this.oFintime = oFintime;
    }

    public String getoRequiretime() {
        return oRequiretime;
    }

    public void setoRequiretime(String oRequiretime) {
        this.oRequiretime = oRequiretime;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public int getoState() {
        return oState;
    }

    public void setoState(int oState) {
        this.oState = oState;
    }

    public String getoAccepttime() {
        return oAccepttime;
    }

    public void setoAccepttime(String oAccepttime) {
        this.oAccepttime = oAccepttime;
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
                ", oPublishtime='" + oPublishtime + '\'' +
                ", oAccepttime='" + oAccepttime + '\'' +
                ", oEndtime='" + oEndtime + '\'' +
                ", oFintime='" + oFintime + '\'' +
                ", oRequiretime='" + oRequiretime + '\'' +
                ", locate='" + locate + '\'' +
                ", oState=" + oState +
                '}';
    }
}
