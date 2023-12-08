package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SeminarBooking;
import com.example.demo.entity.SeminarBookingDTO;
import com.example.demo.utils.IsBookResult;

import java.util.List;

/**
* @author 86135
* @description 针对表【seminar_booking】的数据库操作Service
* @createDate 2023-11-19 20:45:18
*/
public interface SeminarBookingService extends IService<SeminarBooking> {

    /**
     * 查询用户所有预约记录
     * @param seminarUserId
     * @return
     */
    public List<SeminarBooking> getAllBySeminarUserId(String seminarUserId);

    /**
     * 删除预约记录
     * @param username
     * @param room
     * @param date
     * @return
     */
    public boolean delete(String username,int room,String date);


    /**
     * 是否可以预约
     * @param seminarBookingDTO
     * @return
     */
    IsBookResult isBook(SeminarBookingDTO seminarBookingDTO);
}
