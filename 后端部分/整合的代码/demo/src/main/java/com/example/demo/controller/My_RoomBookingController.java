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
     * 查看我的所有预约
     * @param seminarUserId
     * @return
     */
    @RequestMapping("/{seminarUserId}")
    @ResponseBody
    public Result<List<SeminarBooking>> getAllBySeminarUserId(@PathVariable("seminarUserId") String seminarUserId) {
        List<SeminarBooking> seminarBookingList = seminarBookingService.getAllBySeminarUserId(seminarUserId);
        if (seminarBookingList.isEmpty()){
            return Result.error("403","暂无预约");
        }else {
            return Result.success("203",seminarBookingList,"成功");
        }
    }

    /**
     * 删除预约
     * @param username
     * @param room
     * @param date
     * @return
     */
    @RequestMapping("/{username}/{room}/{date}")
    public Result delete(@PathVariable String username, @PathVariable int room, @PathVariable String date){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String msg = username + "预约记录:" + date + " " + room ;
        if (seminarBookingService.delete(username,room,date)) {
            return Result.success("205", dateTime.format(formatter), msg+" 成功取消");
        }
        else{
            return Result.error("405",msg+" 取消失败");
        }
    }

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