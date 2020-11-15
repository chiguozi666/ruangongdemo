package com.mingyuan.bangbang.service;

import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;

public interface UserService {
    public ResultVo login(String unionid, String js_code);
    public ResultVo updateSmallUser(UserInfo userInfo,String token);
    public ResultVo register(UserInfo userInfo,String token);

}
