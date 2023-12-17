package com.example.blacklist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value="blacklist")
@Data
public class BlackEntity implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer blackListId;
    private String username;
    private String reason;
//    private String createUserId;
}
