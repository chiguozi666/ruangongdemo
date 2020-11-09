package com.mingyuan.bangbang.mapper;

import com.mingyuan.bangbang.pojo.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CreditHistory {
    public List<CreditHistory> getCreditHistoriesByUnionid(int unionid);
    public CreditHistory getCreditHistory(@Param("chId") int chId);
    public int updateCreditHistory(@Param("creditHistory") CreditHistory creditHistory);
    public void deleteCreditHistory(@Param("creditHistory")int chId);
    public void insertCreditHistory(CreditHistory creditHistory);
}
