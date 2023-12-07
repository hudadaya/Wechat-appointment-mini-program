package com.example.blacklist.service.impl;

import com.example.blacklist.mapper.BlackEntityMapper;
import com.example.blacklist.service.BlackEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/29 21:28
 * @Description:
 * @Version: 1.0
 */
@Service
public class BlackEntityServiceImpl implements BlackEntityService {

    @Autowired
    private BlackEntityMapper blackEntityMapper;

    /**
     * 查询黑名单
     * @return
     */
    @Override
    public List<String> getList(String username) {
        return blackEntityMapper.selectByUsername(username);
    }
}
