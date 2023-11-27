package com.dragon.springbootmybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dragon.springbootmybatis.entity.MyDate;
import com.dragon.springbootmybatis.entity.SeminarBooking;
import com.dragon.springbootmybatis.mapper.SeminarBookingMapper;
import com.dragon.springbootmybatis.service.SeminarBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* @author Dragon
* @description 针对表【seminar_booking】的数据库操作Service实现
* @createDate 2023-11-23 04:21:56
*/
@Service
public class SeminarBookingServiceImpl extends ServiceImpl<SeminarBookingMapper, SeminarBooking>
    implements SeminarBookingService {
    @Autowired
    SeminarBookingMapper seminarBookingMapper;
    //public void insertData(SeminarBooking seminarBooking) {
    public String insertData(SeminarBooking seminarBooking) {
        // 创建 SimpleDateFormat 对象，并指定日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 使用 SimpleDateFormat 格式化日期为字符串
        String date = sdf.format(seminarBooking.getSeminarDate());

        // 打印格式化后的字符串
        System.out.println("Formatted Date String: " + date);


        // 第一个拒绝预约的条件
        if(seminarBookingMapper.ifExist(seminarBooking.getSeminarUserId(), date) != null) {
            return "用户今天已经预约";
        }
        // 第二个拒绝预约的条件
        if(seminarBooking.getStartTimeId() == (seminarBooking.getEndTimeId() + 1)) {
            return "开始时间和结束时间不可一致";
        }
        // 第三个拒绝预约的条件
        if(seminarBooking.getStartTimeId() > (seminarBooking.getEndTimeId() + 1)) {
            return "开始时间不可大于结束时间";
        }
        // 第四个拒绝的条件
        if(seminarBooking.getEndTimeId() + 1 - seminarBooking.getStartTimeId() > 4) {
            return "预约时间不可大于两小时";
        }
        // 第五个拒绝的条件
        if(seminarBookingMapper.ifConflict(seminarBooking.getStartTimeId(), seminarBooking.getEndTimeId(),
                date, seminarBooking.getSeminarRoomNumber()) != 0) {
            return "时间与已有预约冲突，请重新选择";
        }
        SeminarBookingServiceImpl seminarBookingService = new SeminarBookingServiceImpl();
        seminarBookingService.fixData(seminarBooking);
        seminarBooking.setCreateUserId(seminarBooking.getSeminarUserId());
        seminarBookingMapper.insert(seminarBooking);
        return "用户预约成功";
    }

    /*
    本方法用于补全用户信息，此处补全的为进行操作的用户信息
    创建的用户id需要根据是否为第一次插入而再去判断
     */
    public SeminarBooking fixData(SeminarBooking seminarBooking) {
        seminarBooking.setStartTime(MyDate.dateId2Date(seminarBooking.getStartTimeId()));
        seminarBooking.setEndTime(MyDate.dateId2Date(seminarBooking.getEndTimeId() + 1));
        seminarBooking.setUpdateUserId(seminarBooking.getSeminarUserId());
        return seminarBooking;
    }
}




