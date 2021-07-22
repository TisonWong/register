package com.meal.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meal.register.entity.Registration;
import com.meal.register.entity.dto.RegistrationDto;
import com.meal.register.mapper.RegistrationDtoMapper;
import com.meal.register.service.IRegistrationDtoService;
import com.meal.register.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * 月记录查询 服务实现类
 * </p>
 *
 * @author Tison
 * @since 2021-07-22
 */
@Service
public class RegistrationDtoServiceImpl extends ServiceImpl<RegistrationDtoMapper, RegistrationDto> implements IRegistrationDtoService {

    @Autowired
    private MyTool myTool;

    @Override
    public void selectMonthPage(Page<RegistrationDto> registrationPage, String searchText, String startDate, String endDate) {
        LocalDateTime startLocalDateTime = null;
        LocalDateTime endLocalDateTime = null;
        RegistrationDto registrationDto = null;

        QueryWrapper<RegistrationDto> queryWrapper = new QueryWrapper<>();


        if(null != startDate && !startDate.isEmpty()){
            startLocalDateTime = LocalDateTime.of(LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE), LocalTime.of(0,0));
        }if(null != endDate && !endDate.isEmpty()){
            endLocalDateTime = LocalDateTime.of(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE),LocalTime.of(23,59));
        }

        if(null != searchText && !searchText.isEmpty()){
            registrationDto = new RegistrationDto();
            registrationDto.setMemberName(searchText);
        }

        queryWrapper.select("register_id","member_name","dinner_date as dinnerMonth","department_name","COUNT(member_name) as dinnerCount");

        if(null != startLocalDateTime && null != endLocalDateTime){
            queryWrapper.between("create_date",startLocalDateTime,endLocalDateTime);
        }else if(null != startLocalDateTime){
            queryWrapper.ge("create_date",startLocalDateTime);
        }else if(null != endLocalDateTime){
            queryWrapper.le("create_date",endLocalDateTime);
        }
        if (null != registrationDto){
            queryWrapper.like("member_name",registrationDto.getMemberName());
        }

        queryWrapper.groupBy("member_name");

        baseMapper.selectPage(registrationPage,queryWrapper);
    }
}
