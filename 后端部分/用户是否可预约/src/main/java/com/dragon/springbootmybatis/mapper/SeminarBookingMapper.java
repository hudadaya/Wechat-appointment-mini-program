package com.dragon.springbootmybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dragon.springbootmybatis.entity.SeminarBooking;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
* @author Dragon
* @description 针对表【seminar_booking】的数据库操作Mapper
* @createDate 2023-11-23 04:21:56
* @Entity generator.entity.SeminarBooking
*/

@Repository
@Mapper
public interface SeminarBookingMapper extends BaseMapper<SeminarBooking> {
    //@Select("select * from seminar_booking") 这是加注解的写法，如果我们不加，就要写配置文件
    // 一般开发来说，我们都不会加这个注解，而是直接去写配置文件
    public List<User> findAll();

    /*
    用于查看用户今天是否已经预约
     */
    SeminarBooking ifExist(String id, String date);
    Integer ifConflict(int startTimeId, int endTimeId, String date, int roomId);

}




