package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @TableName seminar_booking
 */
@TableName(value ="seminar_booking")
@Data
public class SeminarBooking implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer seminarBookId;

    private String seminarUserId;

    private Integer seminarRoomNumber;

    private LocalDate seminarDate;

    private String startTime;//String --> Integer

    private String endTime;////String --> Integer

    private Integer startTimeId;

    private Integer endTimeId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createUserId;

    private String updateUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}