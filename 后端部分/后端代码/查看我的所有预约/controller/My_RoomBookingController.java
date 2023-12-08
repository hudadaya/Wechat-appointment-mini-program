package com.example.demo.demos.web.controller;

import com.example.demo.demos.web.entity.SeminarBooking;
import com.example.demo.demos.web.service.ServiceImpl.SeminarBookingService;
import com.example.demo.demos.web.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/seminar/appointments")
public class My_RoomBookingController {
    @Resource
    private SeminarBookingService seminarBookingService;
    @RequestMapping("/{seminarUserId}")
    @ResponseBody
    public Result<List<SeminarBooking>> getAllBySeminarUserId(@PathVariable("seminarUserId") String seminarUserId) {
        List<SeminarBooking> seminarBookingList = seminarBookingService.getAllBySeminarUserId(seminarUserId);
        if (seminarBookingList.isEmpty()){
            return Result.error("0","暂无预约");
        }else {
            return Result.success("200",seminarBookingList,"成功");
        }
    }
}