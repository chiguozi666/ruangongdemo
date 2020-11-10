package com.mingyuan.bangbang.pojo;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo {

    private String code;
    private Object data;
    private String msg;

    private ResultVo(){
    }

//    @JsonIgnore
//    public boolean isSuccess(){
//        return SUCCESS.getCode().equals(this.code);
//    }

    public ResultVo(String code){
        this.code = code;
    }

    public ResultVo(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResultVo(String code, Object data){
        this.code = code;
        this.data = data;
    }

    public ResultVo(String code, String msg, Object data){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }
    public Object getData() {
        return data;
    }
    public String getMsg() {
        return msg;
    }
}
