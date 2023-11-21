package com.example.appointment.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: ytding
 * @Date: 2023/11/20 18:25
 * @Description:
 * @Version: 1.0
 */
@Data
public class Announcement {
    private Integer annountmentId;
    private String title;
    private String content;
    private Integer createUserId;
    private Integer updateUserId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
