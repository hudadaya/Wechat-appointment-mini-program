package com.mjk.delect.controller;

import com.mjk.delect.mapper.SeminarBookingMapper;
import com.mjk.delect.utils.Result;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class controller {
   @Autowired
    SeminarBookingMapper seminarBookingMapper;

    @RequestMapping("delete/{id}")
    public Result delete(@PathVariable String id){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        if (seminarBookingMapper.delete(id) == 1) {
            return com.mjk.delect.utils.Result.success("205", dateTime.format(formatter), "删除成功");
        }
        else{
            return com.mjk.delect.utils.Result.error("405","删除失败");
        }

    }
}
