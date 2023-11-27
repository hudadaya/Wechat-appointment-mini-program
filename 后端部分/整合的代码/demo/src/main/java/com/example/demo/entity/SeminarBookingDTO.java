package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDate;

/**
 * @Author: ytding
 * @Date: 2023/11/26 23:48
 * @Description: 接收前端数据
 * @Version: 1.0
 */

@Data
public class SeminarBookingDTO {
    private String seminarUserId;
    private Integer seminarRoomNumber;
    private LocalDate seminarDate;  // LocalDate 年月日
    private Integer startTimeId;
    private Integer endTimeId;
}
