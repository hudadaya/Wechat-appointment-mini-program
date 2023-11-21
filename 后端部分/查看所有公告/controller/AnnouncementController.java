package com.example.appointment.controller;

import com.example.appointment.entity.Announcement;
import com.example.appointment.utils.Result;
import com.example.appointment.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ytding
 * @Date: 2023/11/20 18:40
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/notice")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    /**
     * 查询所有公告
     * 测试url：http://localhost:8081/notice
     * @return
     */
    @GetMapping
    public Result<List<Announcement>> getAllNotices(){
        List<Announcement> list = announcementService.getAllNotices();
        if(list == null){
            return Result.success(402, list,"暂时没有公告");
        }else{
            return Result.success(202, list, "查询公告成功");
        }
    }
}
