package com.example.demo.demos.web.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.demos.web.entity.SeminarBooking;
import com.example.demo.demos.web.mapper.SeminarBookingMapper;
import com.example.demo.demos.web.service.ServiceImpl.SeminarBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeminarBookingServiceImpl extends ServiceImpl<SeminarBookingMapper, SeminarBooking>
    implements SeminarBookingService {
    @Autowired(required = false)
    private SeminarBookingMapper seminarBookingMapper;
    @Override
    public List<SeminarBooking> getAllBySeminarUserId(String seminarUserId){
        System.out.println(seminarBookingMapper.getAllBySeminarUserId(seminarUserId));
        return seminarBookingMapper.getAllBySeminarUserId(seminarUserId);
    }
}




