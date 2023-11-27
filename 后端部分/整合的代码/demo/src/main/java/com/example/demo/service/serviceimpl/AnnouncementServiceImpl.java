package com.example.demo.service.serviceimpl;

import com.example.demo.entity.Announcement;
import com.example.demo.mapper.AnnouncementMapper;
import com.example.demo.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/20 18:44
 * @Description:
 * @Version: 1.0
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    /**
     * 查询所有公告
     * @return
     */
    @Override
    public List<Announcement> getAllNotices() {
        List<Announcement> list = announcementMapper.getAllNotices();
        return list;
    }
}
