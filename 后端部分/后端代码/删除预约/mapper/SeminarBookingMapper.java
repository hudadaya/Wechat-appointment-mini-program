package com.mjk.delect.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mjk.delect.entity.SeminarBooking;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 专属、恶魔
* @description 针对表【seminar_booking】的数据库操作Mapper
* @createDate 2023-11-24 19:57:55
* @Entity generator.entity.SeminarBooking
*/
@Mapper
public interface SeminarBookingMapper extends BaseMapper<SeminarBooking> {
    public int delete(String id);
    }




