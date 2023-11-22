package com.example.demo.demos.web.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.demos.web.entity.UsersEntity;
import com.example.demo.demos.web.mapper.UsersEntityMapper;
import com.example.demo.demos.web.service.serviceimpl.UserLoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLoginServiceImpl  extends ServiceImpl<UsersEntityMapper,UsersEntity> implements UserLoginService{
    @Autowired(required = false)
    private UsersEntityMapper user;

    @Override
    public UsersEntity getselectByUserName(@Param("username") String username,@Param("password")String pwd) {
        System.out.println("收到："+username+" "+pwd+"的登录查询账号请求，即将返回usersalt password");
        return user.selectByUserName(username);
    }


}
