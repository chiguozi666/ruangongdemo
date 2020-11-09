package com.mingyuan.bangbang.pojo;

import java.sql.Time;

public class CreditHistory {

    int o_id;
    int chCreditChange;
    String chReason;
    int chId;
    Time chTime;
    String unionid;
    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getChCreditChange() {
        return chCreditChange;
    }

    public void setChCreditChange(int chCreditChange) {
        this.chCreditChange = chCreditChange;
    }

    public String getChReason() {
        return chReason;
    }

    public void setChReason(String chReason) {
        this.chReason = chReason;
    }

    public int getChId() {
        return chId;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }

    public Time getChTime() {
        return chTime;
    }

    public void setChTime(Time chTime) {
        this.chTime = chTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
