package com.example.appointment.service;

import com.example.appointment.entity.Announcement;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/20 18:44
 * @Description:
 * @Version: 1.0
 */
public interface AnnouncementService {

    /**
     * 查询所有公告
     * @return
     */
    List<Announcement> getAllNotices();
}
