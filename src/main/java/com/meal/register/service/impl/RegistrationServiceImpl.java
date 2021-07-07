package com.meal.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meal.register.entity.Registration;
import com.meal.register.mapper.RegistrationMapper;
import com.meal.register.service.IRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meal.register.util.MyTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
    public void selectPage(Page<Registration> registrationPage, Registration registration , LocalDateTime startDate, LocalDateTime endDate) {

        QueryWrapper<Registration> queryWrapper = new QueryWrapper<>();

        if(null!=startDate && null!=endDate){
            queryWrapper.between("create_date",startDate,endDate);
        }else if(null != startDate){
            queryWrapper.ge("create_date",startDate);
        }else if(null != endDate){
            queryWrapper.le("create_date",endDate);
        }


      baseMapper.selectPage(registrationPage,queryWrapper);
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
