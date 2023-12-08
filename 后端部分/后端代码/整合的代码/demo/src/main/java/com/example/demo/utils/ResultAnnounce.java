package com.example.demo.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 * @param <T>
 */
@Data
public class ResultAnnounce<T> implements Serializable {

    private Integer code; //编码
    private String msg; //错误信息
    private T data; //数据

    public static <T> ResultAnnounce<T> success() {
        ResultAnnounce<T> result = new ResultAnnounce<>();
        result.code = 1;
        return result;
    }

    public static <T> ResultAnnounce<T> success(T object) {
        ResultAnnounce<T> result = new ResultAnnounce<>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> ResultAnnounce<T> success(Integer code, T object) {
        ResultAnnounce<T> result = new ResultAnnounce<>();
        result.data = object;
        result.code = code;
        return result;
    }

    public static <T> ResultAnnounce<T> success(Integer code, T object, String msg) {
        ResultAnnounce<T> result = new ResultAnnounce<>();
        result.data = object;
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static <T> ResultAnnounce<T> error(String msg) {
        ResultAnnounce<T> result = new ResultAnnounce<>();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
