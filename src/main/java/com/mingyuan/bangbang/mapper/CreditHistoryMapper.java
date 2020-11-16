package com.mingyuan.bangbang.mapper;

import com.mingyuan.bangbang.pojo.CreditHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CreditHistoryMapper {
    public List<CreditHistory> getCreditHistoriesByUnionid(int unionid);
    public List<CreditHistory> getCreditHistories();
    public CreditHistory getCreditHistory(@Param("chId") int chId);
    public int updateCreditHistory(@Param("creditHistory") CreditHistory creditHistory);
    public void deleteCreditHistory(@Param("creditHistory")int chId);
    public void insertCreditHistory(CreditHistory creditHistory);
}
