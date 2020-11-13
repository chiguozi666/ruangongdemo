package com.mingyuan.bangbang.service;

import com.mingyuan.bangbang.pojo.ResultVo;

public interface LoginService {
    public ResultVo login(String unionid, String js_code);
}
