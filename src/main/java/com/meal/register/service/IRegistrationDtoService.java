package com.meal.register.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meal.register.entity.Registration;
import com.meal.register.entity.dto.RegistrationDto;

import java.time.LocalDateTime;

/**
 * <p>
 * 月记录查询 服务类
 * </p>
 *
 * @author Tison
 * @since 2021-07-22
 */
public interface IRegistrationDtoService extends IService<RegistrationDto> {

    void selectMonthPage(Page<RegistrationDto> registrationPage, String searchText, String startDate, String endDate);
}
