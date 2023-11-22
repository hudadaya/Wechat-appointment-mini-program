package com.example.demo.demos.web.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.demos.web.entity.UsersEntity;
public interface UserLoginService extends IService<UsersEntity> {
    UsersEntity getselectByUserName(String username,String pwd);
}
