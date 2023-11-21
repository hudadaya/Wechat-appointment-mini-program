package com.example.demo.demos.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.demos.web.entity.SeminarBooking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* @author 86135
* @description 针对表【seminar_booking】的数据库操作Mapper
* @createDate 2023-11-20 00:42:41
* @Entity generator.entity.SeminarBooking
*/
@Repository
@Mapper
public interface SeminarBookingMapper extends BaseMapper<SeminarBooking> {

    List<SeminarBooking> getAllBySeminarUserId(@Param("seminarUserId") String seminarUserId);

}




