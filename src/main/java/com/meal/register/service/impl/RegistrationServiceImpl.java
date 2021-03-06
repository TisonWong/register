package com.meal.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meal.register.entity.Registration;
import com.meal.register.entity.dto.RegistrationDto;
import com.meal.register.mapper.RegistrationMapper;
import com.meal.register.service.IRegistrationService;
import com.meal.register.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 登记记录表 服务实现类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements IRegistrationService {

    @Autowired
    private MyTool myTool;

    @Override
    public Integer addRegister(Registration registration) {
        return baseMapper.insert(registration);
    }

    @Override
    public Integer deleteRegister(Registration registration) {
        return baseMapper.deleteById(registration.getRegisterId());
    }

    @Override
    public void selectPage(Page<Registration> registrationPage, String searchText, String startDate, String endDate) {
        LocalDateTime startLocalDateTime = null;
        LocalDateTime endLocalDateTime = null;
        Registration registration = null;

        if(null != startDate && !startDate.isEmpty()){
            startLocalDateTime = LocalDateTime.of(LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE), LocalTime.of(0,0));
        }if(null != endDate && !endDate.isEmpty()){
            endLocalDateTime = LocalDateTime.of(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE),LocalTime.of(23,59));
        }if(null != searchText && !searchText.isEmpty()){
            registration = new Registration();
            registration.setMemberName(searchText);
        }

        QueryWrapper<Registration> queryWrapper = new QueryWrapper<>();

        if(null != startLocalDateTime && null != endLocalDateTime){
            queryWrapper.between("create_date",startLocalDateTime,endLocalDateTime);
        }else if(null != startLocalDateTime){
            queryWrapper.ge("create_date",startLocalDateTime);
        }else if(null != endLocalDateTime){
            queryWrapper.le("create_date",endLocalDateTime);
        }
        if (null!=registration){
            queryWrapper.like("member_name",registration.getMemberName());
        }

        baseMapper.selectPage(registrationPage, queryWrapper);
    }

    @Override
    public Registration getObj(Registration registration) {
        LocalDate nextDay = myTool.getNextDay();

        QueryWrapper<Registration> registrationQueryWrapper = new QueryWrapper<>();
        registrationQueryWrapper.eq("dinner_date",nextDay);
        registrationQueryWrapper.eq("member_name",registration.getMemberName());

        return baseMapper.selectOne(registrationQueryWrapper);
    }
}
