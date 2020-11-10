package com.mingyuan.bangbang.util;


import com.mingyuan.bangbang.code.ResultCode;
import com.mingyuan.bangbang.pojo.ResultVo;

import static com.mingyuan.bangbang.code.ResultCode.*;

/**
 * 返回结果，工具类
 */
public class ResultUtil {

    /**
     *  返回信息的成功请求
     * @return
     */
    public static ResultVo success(){
        return new ResultVo(SUCCESS.getCode(),SUCCESS.getMsg(),"");
    }

    /**
     * 返回带有数据的成功请求
     * @param data
     * @return
     */
    public static ResultVo successWithData(Object data){
        return new ResultVo(SUCCESS.getCode(),"",data);
    }

    /**
     * 返回带有数据和消息的成功请求
     * @param msg
     * @return
     */
    public static ResultVo successWitMsg(String msg){
        ResultVo resultVo = new ResultVo(SUCCESS.getCode(), msg,"");
        return resultVo;
    }

    /**
     * 自定义成功请求
     * @param msg
     * @param data
     * @return
     */
    public static ResultVo successWithAll(String msg, Object data){
        return new ResultVo(SUCCESS.getCode(),msg,data);
    }

    /**
     * 返回带有错误消息的成功请求
     * @return
     */
    public static ResultVo error(){
        return new ResultVo(ERROR.getCode(),ERROR.getMsg(),"");
    }

    /**
     * 返回带有数据的失败请求
     * @param data
     * @return
     */
    public static ResultVo errorWithData(Object data){
        return new ResultVo(ERROR.getCode(),"",data);
    }

    /**
     * 返回带有错误信息和数据的失败请求
     * @param msg
     * @return
     */
    public static ResultVo errorWithMsg(String msg){
        return new ResultVo(ERROR.getCode(),msg,"");
    }

    /**
     * 返回带有错误信息和数据的失败请求
     * @param msg
     * @return
     */
    public static ResultVo UNAUTHORIZED(String msg){
        return new ResultVo(UNAUTHORIZED.getCode(),msg,"");
    }
    
    /**
     * 返回自定义数据格式的失败请求
     * @param msg
     * @param data
     * @return
     */
    public static ResultVo errorWithAll(String msg, Object data){
        return new ResultVo(ERROR.getCode(),msg,data);
    }

    public static ResultVo other(ResultCode code){
        return new ResultVo(code.getCode(),code.getMsg(),"");
    }
}
