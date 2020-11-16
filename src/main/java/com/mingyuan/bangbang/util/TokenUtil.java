package com.mingyuan.bangbang.util;

import com.mingyuan.bangbang.exceptions.TokenExceptions;
import org.springframework.data.redis.core.ValueOperations;


import java.util.Random;


public class TokenUtil {



    public static String createToken(ValueOperations valueOperations,String unionid){
        Random random = new Random();
        String token = (random.nextInt(80000)+10000)+"."+unionid+"."+(random.nextInt(80000)+10000);
        System.out.println(token);
        RedisUtil.setToken(valueOperations,token);
        return token;
    }
    public static String getUnionId(ValueOperations valueOperations,String token){
        System.out.println(token);
        String unionid = RedisUtil.getUnionId(valueOperations,token);
        if(unionid==null)throw new TokenExceptions("tokenutil这里的token错误");
//        String s [] = token.split("\\.");
//        if(s.length!=3){
//            System.out.println("token错误");
//            return null;
//        }
//        return token.split("\\.")[1];
        return unionid;
    }

}