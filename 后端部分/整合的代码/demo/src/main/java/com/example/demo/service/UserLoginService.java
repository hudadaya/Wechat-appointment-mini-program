package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.UsersEntity;

public interface UserLoginService extends IService<UsersEntity> {
    UsersEntity getselectByUserName(String username,String pwd);
    Boolean isBlack(String username);
}
