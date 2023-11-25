package com.dragon.springbootmybatis.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    该类专门用以处理每天的预约时间
 */
public class MyDate {
    public static Date dateId2Date(int dateId) {
        // 定义起始时间和结束时间
        LocalTime startTime = LocalTime.of(8, 0); // 早上8点
        LocalTime endTime = LocalTime.of(20, 0); // 晚上8点

        // 定义时间间隔为30分钟
        int intervalMinutes = 30;

        // 使用DateTimeFormatter定义输出格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // 使用ArrayList存储时间点
        List<String> timePoints = new ArrayList<>();

        // 循环生成时间点
        LocalTime currentTime = startTime;
        while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
            // 排除12点到13点的时间段
            if (!(currentTime.equals(LocalTime.of(11, 30)) || currentTime.equals(LocalTime.of(12, 00)) || currentTime.equals(LocalTime.of(12, 30)))) {
                // 处理当前时间点
                String formattedTime = currentTime.format(formatter);
                timePoints.add(formattedTime);
            }

            // 增加时间间隔
            currentTime = currentTime.plusMinutes(intervalMinutes);
        }

        // 定义日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        Date date;
        try {
            // 将字符串转换为Date对象
            date = dateFormat.parse(timePoints.get((dateId - 1)));

            // 打印转换后的Date对象
           System.out.println(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

         //打印存储的时间点
        for (String timePoint : timePoints) {
            System.out.println(timePoint);
        }
        return date;
    }
}

