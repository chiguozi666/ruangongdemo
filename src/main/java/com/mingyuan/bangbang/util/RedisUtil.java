package com.mingyuan.bangbang.util;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * redis操作工具类
 */
public class RedisUtil {
    private static final String PROJECT_NAME = "cgz.";
    private static final String USER_PREFIX = "usr.";
    private static final String TOKEN_VAL = "tok";



    private static final Integer SESSION_EXPIRE_SECONDES =  3000 * 60;
    private static final Integer IMG_CODE_SECONDES =  30 * 60;//验证码有效时间
    private static final Integer OPEN_ID_SECONDES =  30 * 60;//openid有效时间
    private static final Integer PHONE_CODE_SECONDES =  5 * 60;//微博openid有效时间
    private static final Integer RESET_PASS_PHONE_CODE_SECONDES =  5 * 60;//重置密码手机验证码有效时间



    public static void setToken(ValueOperations<String,String> valueOperations,String token){
        if (valueOperations == null || token == null){
            return ;
        }
        String unionid = token.split("\\.")[1];
        valueOperations.set(PROJECT_NAME+USER_PREFIX+TOKEN_VAL+token, unionid,Duration.ofSeconds(OPEN_ID_SECONDES));
    }

    public static String getUnionId(ValueOperations<String,String> valueOperations, String token){
        if (valueOperations == null || token == null){
            System.out.println("valueOperations"+"是空的");
            return null;
        }

        String unionid = valueOperations.get(PROJECT_NAME+USER_PREFIX+TOKEN_VAL + token);
        return unionid;
    }


}
