package com.dragon.springbootmybatis.entity;

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
    private Integer startTimeId;

    /**
     * 
     */
    private Date startTime;

    /**
     * 
     */
    private Integer endTimeId;

    /**
     * 
     */
    private Date endTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String createUserId;

    /**
     * 
     */
    private String updateUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SeminarBooking other = (SeminarBooking) that;
        return (this.getSeminarBookId() == null ? other.getSeminarBookId() == null : this.getSeminarBookId().equals(other.getSeminarBookId()))
            && (this.getSeminarUserId() == null ? other.getSeminarUserId() == null : this.getSeminarUserId().equals(other.getSeminarUserId()))
            && (this.getSeminarRoomNumber() == null ? other.getSeminarRoomNumber() == null : this.getSeminarRoomNumber().equals(other.getSeminarRoomNumber()))
            && (this.getSeminarDate() == null ? other.getSeminarDate() == null : this.getSeminarDate().equals(other.getSeminarDate()))
            && (this.getStartTimeId() == null ? other.getStartTimeId() == null : this.getStartTimeId().equals(other.getStartTimeId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTimeId() == null ? other.getEndTimeId() == null : this.getEndTimeId().equals(other.getEndTimeId()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSeminarBookId() == null) ? 0 : getSeminarBookId().hashCode());
        result = prime * result + ((getSeminarUserId() == null) ? 0 : getSeminarUserId().hashCode());
        result = prime * result + ((getSeminarRoomNumber() == null) ? 0 : getSeminarRoomNumber().hashCode());
        result = prime * result + ((getSeminarDate() == null) ? 0 : getSeminarDate().hashCode());
        result = prime * result + ((getStartTimeId() == null) ? 0 : getStartTimeId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTimeId() == null) ? 0 : getEndTimeId().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seminarBookId=").append(seminarBookId);
        sb.append(", seminarUserId=").append(seminarUserId);
        sb.append(", seminarRoomNumber=").append(seminarRoomNumber);
        sb.append(", seminarDate=").append(seminarDate);
        sb.append(", startTimeId=").append(startTimeId);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTimeId=").append(endTimeId);
        sb.append(", endTime=").append(endTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", updateUserId=").append(updateUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}