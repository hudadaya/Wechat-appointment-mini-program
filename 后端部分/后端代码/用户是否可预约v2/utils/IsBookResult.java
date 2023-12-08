package com.example.demo.utils;

import lombok.Data;

/**
 * @Author: ytding
 * @Date: 2023/11/27 0:10
 * @Description:
 * @Version: 1.0
 */
@Data
public class IsBookResult {
    private String code;
    private String msg;

    public IsBookResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
