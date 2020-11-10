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

    private static final String INIT_ADDRESS = "ai.";//initial id of user
    private static final String AUTHORIZA_ID_KEY = "ak";//initial id of user
    private static final String REDIS_PROJECT_PREFIX = "bs.";//the prefix of this project in redis database
    private static final String USER_ID_KEY = "ui";
    private static final String SESSION_KEY_PREFIX = "sn.";
    private static final String IMG_CODE_PREFIX = "ic.";//验证码前缀
    private static final String OPEN_ID_PREFIX = "oi.";//openid
    private static final String PHONE_CODE_PREFIX = "pc.";//手机验证码
    private static final String RESET_PASS_PHONE_CODE_PREFIX = "rsppc.";//重置密码手机验证码
    private static final String INIT_CATEGORY = "cg.";//农产品类别
    private static final String INIT_STATION = "st.";//站点
    private static final String INIT_STATION_MEMBER = "sm.";//station member
    private static final String INIT_PRODUCT = "p";//product
    private static final String INIT_ORDERNO = "o.";//order
    private static final String INIT_RECOMMEND = "rmd.";

    private static final String INIT_ORDERDETAILNO = "od.";//order_detail
    private static final String INIT_PAYINFONO = "pin.";
    private static final String INIT_DELIVERYNO = "dn.";//deliveryno
    private static final String INIT_COLLECTION = "c.";
    private static final String INIT_REPORT = "rp.";
    private static final String INIT_TAKEMONEYNO = "tm.";

    private static final String INIT_USER_ID = "0";//initial id of user
    private static final String INIT_AUTHORIZA_ID = "0";//initial id of user
    private static final String INIT_ADDRESS_ID = "0";//initial id of user
    private static final String INIT_CATEGORY_ID = "0";
    private static final String INIT_STATION_ID = "0";
    private static final String INIT_STATION_MEMBER_ID = "0";
    private static final String INIT_PRODUCT_ID = "0";

    private static final String INIT_ORDERNO_ID = "0";
    private static final String INIT_ORDERDETAILNO_ID = "0";
    private static final String INIT_PAYINFONO_ID = "3116004776";
    private static final String INIT_DELIVERYNO_ID = "0";
    private static final String INIT_RECOMMEND_ID = "0";
    private static final String INIT_COLLECTION_ID = "0";
    private static final String INIT_REPORT_ID = "0";
    private static final String INIT_TAKEMONEYNO_ID = "0";

    private static final Integer SESSION_EXPIRE_SECONDES =  3000 * 60;
    private static final Integer IMG_CODE_SECONDES =  30 * 60;//验证码有效时间
    private static final Integer OPEN_ID_SECONDES =  30 * 60;//openid有效时间
    private static final Integer PHONE_CODE_SECONDES =  5 * 60;//微博openid有效时间
    private static final Integer RESET_PASS_PHONE_CODE_SECONDES =  5 * 60;//重置密码手机验证码有效时间

    /**
     * 获取用户id
     * @param valueOperations
     * @return
     */
    public static String getUserId(ValueOperations valueOperations){
        //若没有，则插入默认的用户id
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + USER_ID_KEY,INIT_USER_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + USER_ID_KEY));
    }

    /**
     * 获取授权id
     * @param valueOperations
     * @return
     */
    public static String getAuthorizationId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + AUTHORIZA_ID_KEY,INIT_AUTHORIZA_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + AUTHORIZA_ID_KEY));
    }

    public static String getAddressId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_ADDRESS,INIT_ADDRESS_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_ADDRESS));
    }
    public static String getCategoryId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_CATEGORY,INIT_CATEGORY_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_CATEGORY));
    }
    public static String getStationId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_STATION,INIT_STATION_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_STATION));
    }
    public static String getStationMemberId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_STATION_MEMBER,INIT_STATION_MEMBER_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_STATION_MEMBER));
    }

    public static String getProductId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_PRODUCT,INIT_PRODUCT_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_PRODUCT));
    }

    public static String getOrderNo(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_ORDERNO,INIT_ORDERNO_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_ORDERNO));
    }
    public static String getOrderDetailNo(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_ORDERDETAILNO,INIT_ORDERDETAILNO_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_ORDERDETAILNO));
    }
    public static String getPayInfoNo(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_PAYINFONO,INIT_PAYINFONO_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_PAYINFONO));
    }
    public static String getDeliveryNo(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_DELIVERYNO,INIT_DELIVERYNO_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_DELIVERYNO));
    }
    public static String getRecommedId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_RECOMMEND,INIT_RECOMMEND_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_RECOMMEND));
    }
    public static String getCollectionId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_COLLECTION,INIT_COLLECTION_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_COLLECTION));
    }
    public static String getReportId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_REPORT,INIT_REPORT_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_REPORT));
    }
    public static String getTakeMoneyNo(ValueOperations valueOperations) {

        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_TAKEMONEYNO,INIT_TAKEMONEYNO_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_TAKEMONEYNO));
    }
    /**
     * 购物车主键
     * @param valueOperations
     * @return
     */
   /* public static String getCartId(ValueOperations valueOperations) {
        valueOperations.setIfAbsent( REDIS_PROJECT_PREFIX + INIT_CART,INIT_CART_ID);
        return String.valueOf(valueOperations.increment(REDIS_PROJECT_PREFIX + INIT_CART));
    }*/
    /**
     * 设置全局session，用于分布式集群，值为用户id
     * @param hashOperations
     * @param userId session中存有用户的id
     * 过期时间为30 * 60 秒
     */
    public static void setSessionUserId(HashOperations hashOperations, String globalCookieValue, String userId){
        if (hashOperations == null || userId == null || globalCookieValue == null){
            throw new IllegalArgumentException("set session value error");
        }
        hashOperations.put(REDIS_PROJECT_PREFIX + SESSION_KEY_PREFIX +
                globalCookieValue,USER_ID_KEY,userId);
        hashOperations.getOperations().expire(REDIS_PROJECT_PREFIX + SESSION_KEY_PREFIX +
                globalCookieValue, SESSION_EXPIRE_SECONDES,SECONDS);
    }


    /**
     * 获取用户id
     * @param hashOperations
     * @param globalCookieValue
     * @return
     */
    public static String getSessionUserId(HashOperations hashOperations, String globalCookieValue){
        if (hashOperations == null || globalCookieValue == null){ return null; }
        String userId = (String) hashOperations.get(REDIS_PROJECT_PREFIX + SESSION_KEY_PREFIX +
                        globalCookieValue , USER_ID_KEY);
        return userId;
    }

    public static void delSessionUserId(HashOperations hashOperations, String globalCookieValue){
        if (hashOperations == null || globalCookieValue == null){return ; }
        hashOperations.delete(REDIS_PROJECT_PREFIX + SESSION_KEY_PREFIX +
                globalCookieValue ,USER_ID_KEY);
    }


    /**
     * 更新session过期时间
     * @param hashOperations
     * @param globalCookieValue
     */
    public static void updateSessionExpireTime(HashOperations hashOperations, String globalCookieValue){
        if (hashOperations == null || globalCookieValue == null){
            return ;
        }
        Boolean hasSession = hashOperations.getOperations().hasKey(REDIS_PROJECT_PREFIX + SESSION_KEY_PREFIX + globalCookieValue);
        if (hasSession){
            hashOperations.getOperations().expire(REDIS_PROJECT_PREFIX + SESSION_KEY_PREFIX + globalCookieValue,SESSION_EXPIRE_SECONDES,SECONDS);
        }
    }



    /**
     * 写入微博OpenId
     * @param valueOperations
     * @param openId
     * @param cookieVal
     */
    public static void setOpenId(ValueOperations<String, String> valueOperations, String openId, String cookieVal){
        if (valueOperations == null || openId == null || cookieVal == null){
            return ;
        }
        valueOperations.set(REDIS_PROJECT_PREFIX + OPEN_ID_PREFIX + cookieVal,openId, Duration.ofSeconds(OPEN_ID_SECONDES));
    }

    /**
     * 获取微博openId
     * @param valueOperations
     * @param cookieVal
     * @return
     */
    public static String getOpenId(ValueOperations<String, String> valueOperations, String cookieVal){
        if (valueOperations == null || cookieVal == null){
            return null;
        }
       return valueOperations.get(REDIS_PROJECT_PREFIX + OPEN_ID_PREFIX + cookieVal);
    }

    /**
     * 删除微博openId
     * @param valueOperations
     * @param cookieVal
     */
    public static void delOpenId(ValueOperations<String, String> valueOperations, String cookieVal){
        valueOperations.getOperations().delete(REDIS_PROJECT_PREFIX + OPEN_ID_PREFIX + cookieVal);
    }

    /**
     * 写入手机号验证码
     * @param valueOperations
     * @param phoneCode
     * @param cookieVal
     */
    public static Integer setPhoneCode(ValueOperations<String, String> valueOperations, String phoneCode, String cookieVal){
        if (valueOperations == null || phoneCode == null || cookieVal == null){
            return PHONE_CODE_SECONDES;
        }
        valueOperations.set(REDIS_PROJECT_PREFIX + PHONE_CODE_PREFIX + cookieVal,phoneCode, Duration.ofSeconds(PHONE_CODE_SECONDES));
        return PHONE_CODE_SECONDES;
    }

    /**
     * 获取手机验证码
     * @param valueOperations
     * @param cookieVal
     * @return
     */
    public static String getPhoneCode(ValueOperations<String, String> valueOperations, String cookieVal){
        if (valueOperations == null || cookieVal == null){
            return null;
        }
        return valueOperations.get(REDIS_PROJECT_PREFIX + PHONE_CODE_PREFIX + cookieVal);
    }

    /**
     * 删除手机验证码
     * @param valueOperations
     * @param cookieVal
     */
    public static void delPhoneCode(ValueOperations<String, String> valueOperations, String cookieVal){
        valueOperations.getOperations().delete(REDIS_PROJECT_PREFIX + PHONE_CODE_PREFIX + cookieVal);
    }

    /**
     * 重置密码时发送手机号验证码
     * @param valueOperations
     * @param phoneCode
     * @return
     */
    public static Map<String, String> setResetPassPhoneCode(ValueOperations<String, String> valueOperations, String phoneCode){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        Map<String, String> map = new HashMap<>();
        map.put("token",token);
        map.put("expire",RESET_PASS_PHONE_CODE_SECONDES + "");
        valueOperations.set(REDIS_PROJECT_PREFIX + RESET_PASS_PHONE_CODE_PREFIX + token,phoneCode, Duration.ofSeconds(RESET_PASS_PHONE_CODE_SECONDES));
        return map;
    }

    /**
     * 重置密码时发送手机号验证码
     * @param valueOperations
     * @return
     */
    public static String getResetPassPhoneCode(ValueOperations<String, String> valueOperations, String token){
        return valueOperations.get(REDIS_PROJECT_PREFIX + RESET_PASS_PHONE_CODE_PREFIX + token);
    }



}
