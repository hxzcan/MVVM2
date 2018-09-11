package com.hx.http;

/**
 * Created by hexiao on 2018/8/7.
 * 后台返回的数据总格式
 */

public class BaseResult<T> {

    private Integer code;//返回码
    private String message;//返回的信息
    private T   data;//返回的数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
