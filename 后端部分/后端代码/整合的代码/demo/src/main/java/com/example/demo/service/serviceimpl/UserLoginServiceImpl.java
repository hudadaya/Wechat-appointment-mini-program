package com.example.demo.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UsersEntity;
import com.example.demo.mapper.BlackEntityMapper;
import com.example.demo.mapper.UsersEntityMapper;
import com.example.demo.service.UserLoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLoginServiceImpl  extends ServiceImpl<UsersEntityMapper, UsersEntity> implements UserLoginService {
    @Autowired(required = false)
    private UsersEntityMapper user;
    @Autowired(required = false)
    private BlackEntityMapper blackEntityMapper;
    @Override
    public UsersEntity getselectByUserName(String username,String pwd) {
        System.out.println("是否在黑名单:"+blackEntityMapper.selectByUserName1(username));
        System.out.println("收到："+username+" "+pwd+"的登录查询账号请求，即将返回usersalt password（若返回出错请检查数据库连接再次发送）");
        return user.selectByUserName(username);
    }

    @Override
    public Boolean isBlack(String username) {
        if(blackEntityMapper.selectByUserName1(username)!=0)
            return false;
        else
            return true;
    }


}
