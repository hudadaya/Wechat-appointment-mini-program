package com.example.demo.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SeminarBooking;
import com.example.demo.entity.SeminarBookingDTO;
import com.example.demo.mapper.SeminarBookingMapper;
import com.example.demo.service.SeminarBookingService;
import com.example.demo.utils.IsBookResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeminarBookingServiceImpl extends ServiceImpl<SeminarBookingMapper, SeminarBooking>
    implements SeminarBookingService {

    @Autowired(required = false)
    private SeminarBookingMapper seminarBookingMapper;

    /**
     * 是否可以预约
     * @param seminarBookingDTO
     * @return
     */
    @Override
    @Transactional
    public IsBookResult isBook(SeminarBookingDTO seminarBookingDTO) {
        int myStart = seminarBookingDTO.getStartTimeId();
        int myEnd = seminarBookingDTO.getEndTimeId();

        // 1. 开始时间不可大于结束时间
        if(myStart > myEnd){
            return new IsBookResult("440", "开始时间不可大于结束时间");
        }

        // 2. 单次预约时间不得超过2个小时
        if(myStart + 4 <= myEnd){
            return new IsBookResult("443", "单次预约时间不得超过2个小时");
        }

        // 3. 今日已预约过研讨室，不可再次预约
        List<SeminarBooking> list1 = seminarBookingMapper.selectByUserIDAndDate(seminarBookingDTO);
        if(!list1.isEmpty()){   // 这里用 list!=null 来判断就不行！！why？
            return new IsBookResult("442", "今日已预约过研讨室，不可再次预约");
        }

        // 4. 时间与已有预约冲突，请重新预约
        List<SeminarBooking> list2 = seminarBookingMapper.selectByDateAndROOM(seminarBookingDTO);
        if(!list2.isEmpty()){
            for(int i = 0; i < list2.size(); i++){
                int start = list2.get(i).getStartTimeId();
                int end = list2.get(i).getEndTimeId();
                // 8:00start  22:00end 考虑特殊情况   （也可以根据下列条件进行筛查
                if((myStart >= start - 1 && myStart <= end + 1) || (myEnd >= start - 1 && myEnd <= end + 1)){
                    return new IsBookResult("441", "所选时间与已有预约冲突，请重新预约");
                }
            }
        }

        // 5. 成功预约
        SeminarBooking seminarBooking = new SeminarBooking();
        BeanUtils.copyProperties(seminarBookingDTO, seminarBooking);
        seminarBooking.setCreateUserId(seminarBooking.getSeminarUserId());   // TODO：看看前端能不能给我这个数据，不能的话就登录的时候保存用户的username
        seminarBooking.setUpdateUserId(seminarBooking.getSeminarUserId());
        seminarBookingMapper.insertdata(seminarBooking);
        return new IsBookResult("240", "预约成功");
    }

}




