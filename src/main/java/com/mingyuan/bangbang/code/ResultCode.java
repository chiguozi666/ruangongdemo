package com.mingyuan.bangbang.code;


/**
 * 返回结果枚举类
 */
public enum ResultCode {

    //100开头都是错误消息
    ERROR("100","error"),

    //200开头都是成功消息
    SUCCESS("200","success"),

    UNAUTHORIZED("401", "暂未登录或token已经过期"),
    
    //300为其他结果
    WEIBO_BANG("300","请绑定手机号"),//绑定手机号
    QQ_BANG("301","请绑定手机号"),//绑定手机号
    ;
    private String code;
    private String msg;
    ResultCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
