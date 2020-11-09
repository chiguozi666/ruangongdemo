package com.mingyuan.bangbang.pojo;

public class UserInfo {
    String openid;
    String sessionkey;
    String unionid;
    String uName;
    String uStudentnum;
    String uIdentify;
    int uCredit;
    int uPhone;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuStudentnum() {
        return uStudentnum;
    }

    public void setuStudentnum(String uStudentnum) {
        this.uStudentnum = uStudentnum;
    }

    public String getuIdentify() {
        return uIdentify;
    }

    public void setuIdentify(String uIdentify) {
        this.uIdentify = uIdentify;
    }

    public int getuCredit() {
        return uCredit;
    }

    public void setuCredit(int uCredit) {
        this.uCredit = uCredit;
    }

    public int getuPhone() {
        return uPhone;
    }

    public void setuPhone(int uPhone) {
        this.uPhone = uPhone;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "oppenid='" + openid + '\'' +
                ", sessionkey='" + sessionkey + '\'' +
                ", unionid='" + unionid + '\'' +
                ", u_name='" + uName + '\'' +
                ", u_studentnum='" + uStudentnum + '\'' +
                ", u_identify='" + uIdentify + '\'' +
                ", u_credit='" + uCredit + '\'' +
                ", u_phone=" + uPhone +
                '}';
    }
}
