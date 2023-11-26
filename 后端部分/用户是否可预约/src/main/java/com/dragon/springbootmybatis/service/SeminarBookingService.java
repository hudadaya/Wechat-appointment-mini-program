package com.dragon.springbootmybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dragon.springbootmybatis.entity.SeminarBooking;

/**
* @author Dragon
* @description 针对表【seminar_booking】的数据库操作Service
* @createDate 2023-11-23 04:21:56
*/
public interface SeminarBookingService extends IService<SeminarBooking> {
    //void insertData(SeminarBooking seminarBooking);
    String insertData(SeminarBooking seminarBooking);
    SeminarBooking fixData(SeminarBooking seminarBooking);
}
