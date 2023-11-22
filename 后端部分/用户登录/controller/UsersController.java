package com.example.demo.demos.web.controller;

import com.example.demo.demos.web.entity.UsersEntity;
import com.example.demo.demos.web.service.serviceimpl.UserLoginService;
import com.example.demo.demos.web.utils.Result;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class UsersController {
    @Resource
    private UserLoginService userLoginService;
    @PostMapping("/login")
    @ResponseBody
    public Result<UsersEntity> getselectByUserName(@RequestParam("username") String username,@RequestParam("password")String pwd) {
        UsersEntity usersEntity=userLoginService.getselectByUserName(username,pwd);
        Result result=new Result();
        System.out.println("收到："+username+" "+pwd+"登录请求");
        if(usersEntity!=null)
        {   //1.200登录成功
            if(usersEntity.getPassword().equals(encryPwd(usersEntity.getUsersalt(),pwd)))
            {
                result.setCode("200");
                result.setMsg("欢迎"+username+"登录");
                return result;
            }
            else //2.412用户或密码错误
            {
                result.setCode("411");
                result.setMsg("用户名或密码输入错误");
            }
        }
        else //3.411用户不存在
        {
            result.setCode("412");
            result.setMsg("用户不存在");
        }
        return result;
    }

    //salt+pwd 的32位MD5加密
    private String encryPwd(String salt,String pwd)
    {
        String plainText=salt+pwd;
        byte[] mdBytes = null;
        try {
            mdBytes = MessageDigest.getInstance("MD5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5算法不存在！");
        }
        String mdCode = new BigInteger(1, mdBytes).toString(16);

        if(mdCode.length() < 32) {
            int a = 32 - mdCode.length();
            for (int i = 0; i < a; i++) {
                mdCode = "0"+mdCode;
            }
        }
        return mdCode.toUpperCase(); //返回32位大写
    }
}
