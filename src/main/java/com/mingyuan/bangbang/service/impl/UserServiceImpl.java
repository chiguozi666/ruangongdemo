package com.mingyuan.bangbang.service.impl;

import com.mingyuan.bangbang.config.WeixinConfig;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.HttpClientVo;
import com.mingyuan.bangbang.pojo.IntelVo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;
import com.mingyuan.bangbang.service.UserService;
import com.mingyuan.bangbang.util.HttpClientUtil;
import com.mingyuan.bangbang.util.RegUtil;
import com.mingyuan.bangbang.util.ResultUtil;
import com.mingyuan.bangbang.util.TokenUtil;
import org.apache.ibatis.annotations.Select;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;


//https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private WeixinConfig weixinConfig;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ValueOperations valueOperations;
    @Override
    public ResultVo login(String unionid, String js_code) {
        //HttpUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?"+"appid="+APPID+"&secret="+SECRET+"&js_code="+JSCODE+"&grant_type=authorization_code");
        String appid = weixinConfig.getAppid();
        String secret = weixinConfig.getAppsecret();
        System.out.println("appid"+appid+"   secret"+secret);
        HttpClientVo vo = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code");
        if (200 == vo.getCode()){
            String content = vo.getContent();
            JSONObject jsonObject = new JSONObject(content);
            String oppenid;
            String session_key;
            try{
                oppenid = jsonObject.getString("openid");
                session_key = jsonObject.getString("session_key");
            }catch (JSONException e){
                return ResultUtil.errorWithMsg("你的js——code可能过期了");
            }

            //String unionId = jsonObject.getString("unionid");
/// TODO: 2020/11/16 这里存的是openid
            String token = TokenUtil.createToken(valueOperations,oppenid);
            System.out.println("login"+token);
            UserInfo userInfo = userMapper.getUserInfo(oppenid);
            //没有就创建用户数据
            if(userInfo==null){
                userInfo = new UserInfo();
                userInfo.setUnionid(oppenid);
                userInfo.setOpenid(oppenid);
                userInfo.setSessionkey(session_key);
                userMapper.insertUserInfo(userInfo);
                System.out.println(session_key+"用户被创建"+oppenid+"  "+session_key);
            }
            //查看数据库，判断有没有用户信息，以此来判断用户之前有没有绑定过用户信息
            return ResultUtil.successWithAll("登录成功!",new IntelVo(token));
        }
        return ResultUtil.errorWithAll("出现了js_code错误",new JSONObject(vo));
    }
    @Override
    public ResultVo updateSmallUser(UserInfo userInfo,String token){
        String unionid = TokenUtil.getUnionId(valueOperations,token);
        if(userMapper.getUserInfo(unionid)==null){
            return ResultUtil.errorWithMsg("用户的token错误，无法找到对应的用户");
        }else {
            userInfo.setUnionid(unionid);
        }
        if (!RegUtil.check(userInfo.getuIdentify())){
            return ResultUtil.errorWithMsg("身份证信息错误");
        }
        if (!RegUtil.isStudenNum(userInfo.getuStudentnum())){
            return ResultUtil.errorWithMsg("学号信息错误");
        }
        userInfo.setuCredit(userMapper.getUserInfo(unionid).getuCredit());
        System.out.println(userMapper.getUserInfo(unionid).getuCredit());
        userMapper.updateSmallUser(userInfo);
        return ResultUtil.successWitMsg("修改成功");
    }
    @Override
    public ResultVo register(UserInfo userInfo,String token) {
        String unionId = TokenUtil.getUnionId(valueOperations,token);
        if(unionId==null){
            return ResultUtil.errorWithMsg("token错误");
        }
        userInfo.setUnionid(unionId);
        UserInfo origin = userMapper.getUserInfo(unionId);
        if (!RegUtil.isStudenNum(userInfo.getuStudentnum())){
            return ResultUtil.errorWithMsg("学号信息错误");
        }
        if(userMapper.getUserInfo(userInfo.getuStudentnum())!=null){
            return ResultUtil.errorWithMsg("学号已经被注册");
        }
        if (!RegUtil.check(userInfo.getuIdentify())){
            return ResultUtil.errorWithMsg("身份证信息错误");
        }

        userInfo.setSessionkey(null);
        userInfo.setOpenid(null);
        userInfo.setuCredit(100);//起始给100

        int i = userMapper.updateUser(userInfo);
        System.out.println(i);
        return ResultUtil.successWitMsg("注册成功");
    }
}
