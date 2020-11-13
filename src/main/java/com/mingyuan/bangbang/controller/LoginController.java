package com.mingyuan.bangbang.controller;

import cn.hutool.json.JSONObject;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserVo;
import com.mingyuan.bangbang.service.LoginService;
import com.mingyuan.bangbang.util.ResultUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@ApiModel(value="和用户有关的操作",description="请求tocken" )
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private LoginService loginServiceImpl;
    @PostMapping(value = "/login")
    public ResultVo loginUser(@ApiParam(name="传入对象",value="传入json格式",required=true)@RequestBody UserVo userVo){
        System.out.println(userVo.toString());
        ResultVo resultVo = loginServiceImpl.login(userVo.getUnionid(),userVo.getJs_code());
        return resultVo;
    }
    @PostMapping(value = "/update")
    public ResultVo updateUser(@ApiParam(name="传入对象",value="传入json格式",required=true)@RequestBody UserVo userVo, RequestHeader requestHeader){
        ResultVo resultVo = ResultUtil.successWithData(requestHeader.value());
        System.out.println(requestHeader.value());
        return resultVo;
    }
    @PostMapping(value = "/logintest")
    public void loginUser(){
        System.out.println("被按了");
    }
}
