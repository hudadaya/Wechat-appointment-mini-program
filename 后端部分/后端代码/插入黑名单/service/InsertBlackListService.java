package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.BlackEntity;
import com.example.demo.utils.Result;

public interface InsertBlackListService extends IService<BlackEntity> {

    Result insertBlackList(String username,String reason);
}
