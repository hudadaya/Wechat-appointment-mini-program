package com.example.demo.entity;

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
    private Integer announcementId;
    private String title;
    private String content;
    private String createUserId;
    private String updateUserId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
