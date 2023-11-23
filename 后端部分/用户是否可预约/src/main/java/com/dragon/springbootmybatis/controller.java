package com.dragon.springbootmybatis;

import com.dragon.springbootmybatis.entity.SeminarBooking;
import com.dragon.springbootmybatis.mapper.SeminarBookingMapper;
import com.dragon.springbootmybatis.service.SeminarBookingService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("request")
public class controller {

    @Autowired(required = false)
    private SeminarBookingMapper seminarBookingMapper;

    @Autowired
    private SeminarBookingService seminarBookingService;

    // 以下都是在测试
    @RequestMapping("hello3")
    public List<User> play() {
        List<User> list = seminarBookingMapper.findAll();
        return list;
    }

    @GetMapping("test/{id}")
    public String order(@PathVariable String id) {
        return id;
    }

    @RequestMapping("insert/{id}")
    public String insertData(@PathVariable String id) {
        // 多道关卡
        return "ok";
    }
    // 以上都是在测试

    @PostMapping("/SeminarBooking")
    @ResponseBody
    public String doSome(@RequestBody SeminarBooking seminarBooking) throws ParseException {
        return seminarBookingService.insertData(seminarBooking);

    }
//    public SeminarBooking doSome(@RequestBody SeminarBooking seminarBooking) {
//        return seminarBooking;
//    }

}
