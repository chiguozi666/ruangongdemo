package com.mingyuan.bangbang.util;

import com.mingyuan.bangbang.pojo.CreditHistory;

public class CreditUtil {
    public static CreditHistory OverTime_reduce_10(int oId,String unionId){
        CreditHistory creditHistory = new CreditHistory();
        creditHistory.setChReason("用户完成超时，减去10点信誉度");
        creditHistory.setChTime(String.valueOf(System.currentTimeMillis()));
        creditHistory.setUnionid(unionId);
        creditHistory.setChCreditChange(-10);
        creditHistory.setoId(oId);
        return creditHistory;
    }
    public static CreditHistory Finish_plus_1(int oId,String unionId){
        CreditHistory creditHistory = new CreditHistory();
        creditHistory.setChReason("用户完成，增加1点信誉度");
        creditHistory.setChTime(String.valueOf(System.currentTimeMillis()));
        creditHistory.setUnionid(unionId);
        creditHistory.setChCreditChange(1);
        creditHistory.setoId(oId);
        return creditHistory;
    }
}
