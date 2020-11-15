package com.mingyuan.bangbang.controller;

import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;
import com.mingyuan.bangbang.pojo.UserVo;
import com.mingyuan.bangbang.service.UserService;
import com.mingyuan.bangbang.util.ResultUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@ApiModel(value="和用户有关的操作",description="请求tocken" )
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userServiceImpl;
    @PostMapping(value = "/login")
    public ResultVo loginUser(@ApiParam(name="传入对象",value="传入json格式",required=true)@RequestBody UserVo userVo){
        System.out.println(userVo.toString());
        ResultVo resultVo = userServiceImpl.login(userVo.getUnionid(),userVo.getJs_code());
        return resultVo;
    }
    @PostMapping(value = "/update")
    public ResultVo updateUser(@ApiParam(name="传入需要修改的对象",value="传入json格式,根据token和unionid是否匹配判断是否修改",required=true)@RequestBody UserInfo userInfo, @RequestHeader("token") String token){
        ResultVo resultVo = userServiceImpl.updateSmallUser(userInfo,token);
        System.out.println(token);
        return resultVo;
    }
    @PostMapping(value = "/register")
    public ResultVo loginUser(@ApiParam(name="传入需要修改的对象",value="传入json格式,根据token和unionid是否匹配判断是否修改",required=true)@RequestBody UserInfo userInfo, @RequestHeader("token") String token){
        ResultVo resultVo = userServiceImpl.register(userInfo,token);
        System.out.println(token);
        return resultVo;
    }
}
