package com.mingyuan.bangbang.mapper;

import com.mingyuan.bangbang.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
@Mapper
public interface UserMapper {
    public ArrayList<UserInfo> getUserInfos();
    public UserInfo getUserInfo(@Param("unionId") String unionId);
    public int updateUser(@Param("userInfo") UserInfo userInfo);
    public void updateSmallUser(@Param("userInfo") UserInfo userInfo);
    public void deleteUser(@Param("unionId") String unionId);
    public void insertUserInfo(UserInfo userInfo);
}
