package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.BlackEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BlackEntityMapper extends BaseMapper<BlackEntity> {
    //插入黑名单
    Boolean insertBlackList(String username,String reason);
    //查询用户是否在黑名单
    int selectUserInBlack(String username);
}