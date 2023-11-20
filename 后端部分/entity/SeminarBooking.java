package com.example.demo.demos.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName seminar_booking
 */
@TableName(value ="seminar_booking")
@Data
public class SeminarBooking implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer seminarBookId;

    /**
     * 
     */
    private String seminarUserId;

    /**
     * 
     */
    private Integer seminarRoomNumber;

    /**
     * 
     */
    private Date seminarDate;

    /**
     * 
     */
    private Integer startTime;

    /**
     * 
     */
    private Integer endTime;

    /**
     * 
     */
//    private Date createTime;

    /**
     * 
     */
//    private Date updateTime;

    /**
     * 
     */
//    private Integer createUserId;

    /**
     * 
     */
//    private Integer updateUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}