package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
@TableName(value="users")
@Data
public class UsersEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    private String username;

    private String password;

    private Short userType;

    private String usersalt;

}