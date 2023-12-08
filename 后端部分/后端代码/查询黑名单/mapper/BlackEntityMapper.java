package com.example.blacklist.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/29 21:27
 * @Description:
 * @Version: 1.0
 */
@Mapper
public interface BlackEntityMapper {

    /**
     * 查询黑名单
     * @return
     */
    List<String> selectByUsername();
}
