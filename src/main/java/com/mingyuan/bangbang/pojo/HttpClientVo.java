package com.mingyuan.bangbang.pojo;

/**
 * 发送http请求响应结果
 */
public class HttpClientVo {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientVo(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpClientVo{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }
}
