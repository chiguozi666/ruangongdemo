package com.mingyuan.bangbang.mapper;

import com.mingyuan.bangbang.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface UserMapper {
    public ArrayList<UserInfo> getUserInfos();
    public UserInfo getUserInfo(String unionId);
    public int updateUser(@Param("userInfo") UserInfo userInfo);

    public void deleteUser(String unionId);
    public void insertUserInfo(UserInfo userInfo);
}
