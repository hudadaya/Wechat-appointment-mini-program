package com.example.demo.controller;

import com.example.demo.entity.SeminarBooking;
import com.example.demo.entity.SeminarBookingDTO;
import com.example.demo.service.SeminarBookingService;
import com.example.demo.utils.IsBookResult;
import com.example.demo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/seminar/appointments")
@Slf4j
public class My_RoomBookingController {
    @Resource
    private SeminarBookingService seminarBookingService;

    /**
     * 是否可以预约
     * @param seminarBookingDTO
     * @return
     */
    @PostMapping
    public Result isBook(@RequestBody SeminarBookingDTO seminarBookingDTO){
        log.info("是否可以预约：" + seminarBookingDTO);
        IsBookResult isBookResult = seminarBookingService.isBook(seminarBookingDTO);
        return Result.success(isBookResult.getCode(), null, isBookResult.getMsg());
    }
}