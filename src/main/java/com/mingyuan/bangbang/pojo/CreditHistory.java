package com.mingyuan.bangbang.pojo;

import java.sql.Time;

public class CreditHistory {

    int oId;
    int chCreditChange;
    String chReason;
    int chId;
    String chTime;
    String unionid;
    public CreditHistory(){}
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
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

    public String getChTime() {
        return chTime;
    }

    public void setChTime(String chTime) {
        this.chTime = chTime;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }


    public CreditHistory(int o_id, int chCreditChange, String chReason, int chId, String chTime, String unionid) {
        this.oId = o_id;
        this.chCreditChange = chCreditChange;
        this.chReason = chReason;
        this.chId = chId;
        this.chTime = chTime;
        this.unionid = unionid;
    }
    public static CreditHistory getTestInstance(){
        CreditHistory creditHistory = new CreditHistory();
        creditHistory.setUnionid("unionid");
        creditHistory.setoId(1344);
        creditHistory.setChCreditChange(-10);
        creditHistory.setChReason("我是原因");
        creditHistory.setChTime(String.valueOf(new Time(System.currentTimeMillis())));
        return creditHistory;
    }
}
