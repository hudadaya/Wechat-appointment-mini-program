package com.example.appointment.mapper;

import com.example.appointment.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/20 18:48
 * @Description:
 * @Version: 1.0
 */
@Mapper
public interface AnnouncementMapper {

    /**
     * 查询所有的公告
     * @return
     */
    List<Announcement> getAllNotices();
}
