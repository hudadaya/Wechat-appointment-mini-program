package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SeminarBooking;
import com.example.demo.entity.SeminarBookingDTO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
* @author 86135
* @description 针对表【seminar_booking】的数据库操作Mapper
* @createDate 2023-11-20 00:42:41
* @Entity generator.entity.SeminarBooking
*/
@Repository
@Mapper
public interface SeminarBookingMapper extends BaseMapper<SeminarBooking> {

    /*delete 删除预约记录*/
    int delete(String username, int room,String date);

    /*getAllBySeminarUserId 查询用户所有预约记录*/
    List<SeminarBooking> getAllBySeminarUserId(@Param("seminarUserId") String seminarUserId);

    /**
     * 新增预约
     * @param seminarBooking
     */
    void insertdata(SeminarBooking seminarBooking);

    /**
     * 判断用户在某天是否预约过研讨室
     * @param seminarUserId
     * @param seminarDate
     * @return
     */
    List<SeminarBooking> selectByUserIDAndDate(SeminarBookingDTO seminarBookingDTO);

    /**
     * 拿到某天某个房间的全部预约记录
     * @param seminarBookingDTO
     * @return
     */
    List<SeminarBooking> selectByDateAndROOM(SeminarBookingDTO seminarBookingDTO);
}




