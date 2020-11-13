package com.mingyuan.bangbang.service.impl;

import com.mingyuan.bangbang.config.WeixinConfig;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.HttpClientVo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;
import com.mingyuan.bangbang.service.LoginService;
import com.mingyuan.bangbang.util.HttpClientUtil;
import com.mingyuan.bangbang.util.HttpUtil;
import com.mingyuan.bangbang.util.ResultUtil;
import com.mingyuan.bangbang.util.TokenUtil;
import com.sun.org.apache.xml.internal.security.algorithms.Algorithm;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import java.util.Date;


//https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private WeixinConfig weixinConfig;
    @Autowired
    UserMapper userMapper;
    @Override
    public ResultVo login(String unionid, String js_code) {
        //HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?"+"appid="+APPID+"&secret="+SECRET+"&js_code="+JSCODE+"&grant_type=authorization_code");
        String appid = weixinConfig.getAppid();
        String secret = weixinConfig.getAppsecret();
        System.out.println("appid"+appid+"   secret"+secret);
        HttpClientVo vo = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code");
        if (0 == vo.getCode()){
            //获取成功
            String content = vo.getContent();
            JSONObject jsonObject = new JSONObject(content);

            String oppenid = jsonObject.getString("openid");
            String session_key = jsonObject.getString("session_key");
            String unionId = jsonObject.getString("unionid");

            String token = TokenUtil.createToken(session_key,unionid,oppenid);
            UserInfo userInfo = userMapper.getUserInfo(unionId);
            //没有就创建用户数据
            if(userInfo.equals(null)){
                userInfo = new UserInfo();
                userInfo.setUnionid(unionid);
                userInfo.setOpenid(oppenid);
                userInfo.setSessionkey(session_key);
                userMapper.insertUserInfo(userInfo);
                System.out.println(unionId+"用户被创建"+oppenid+"  "+session_key);
            }
            //查看数据库，判断有没有用户信息，以此来判断用户之前有没有绑定过用户信息
            JSONObject result = new JSONObject();
            result.put("token",token);
            return ResultUtil.successWithData(result);
        }
        return ResultUtil.errorWithAll("出现了js_code错误",new JSONObject(vo));
    }

}
