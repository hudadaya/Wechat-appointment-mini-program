package com.example.demo.demos.web.service.ServiceImpl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.demos.web.entity.SeminarBooking;
import com.example.demo.demos.web.utils.Result;

import java.util.List;
import java.util.Map;

/**
* @author 86135
* @description 针对表【seminar_booking】的数据库操作Service
* @createDate 2023-11-19 20:45:18
*/
public interface SeminarBookingService extends IService<SeminarBooking> {
    public List<SeminarBooking> getAllBySeminarUserId(String seminarUserId);
}
