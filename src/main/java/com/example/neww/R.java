package com.example.neww;

import lombok.Data;

import java.io.Serializable;

@Data
public class R <T> implements Serializable {
//    @ApiModelProperty(value = "是否成功")
    private Boolean success;
//    @ApiModelProperty(value = "返回码")
    private Integer code;
//    @ApiModelProperty(value = "返回消息")
    private String message;
//    @ApiModelProperty(value = "返回数据")
    private T data;
    private R(){}
    private R(String message,Integer code,T t){
        this.message = message;
        this.code = code;
        this.data = t;
    }
    private R(String message,Integer code){
        this.message = message;
        this.code = code;
    }
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }


    public static R error(String message){
        return new R(message,ResultCode.ERROR);
    }

    public static R ok(String message){
        return new R(message,ResultCode.SUCCESS);
    }

    public static <T>R<T> ok(String s,T t){
        return new R<T>(s, ResultCode.SUCCESS ,t);
    }

}

