package com.example.blacklist.service;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/29 21:28
 * @Description:
 * @Version: 1.0
 */
public interface BlackEntityService {

    /**
     * 查询黑名单
     * @return
     */
    List<String> getList(String username);
}
