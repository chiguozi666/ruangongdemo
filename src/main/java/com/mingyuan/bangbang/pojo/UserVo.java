package com.mingyuan.bangbang.pojo;

public class UserVo {
    String unionid;
    String js_code;

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public UserVo(String unionid, String jsCode) {
        this.unionid = unionid;
        this.js_code = jsCode;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "unionid='" + unionid + '\'' +
                ", jsCode='" + js_code + '\'' +
                '}';
    }
}
