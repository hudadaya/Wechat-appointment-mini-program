package com.example.demo.demos.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.demos.web.entity.UsersEntity;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsersEntityMapper extends BaseMapper<UsersEntity> {
    UsersEntity selectByUserName(@Param("username") String username);
}