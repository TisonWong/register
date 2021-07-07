package com.meal.register.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meal.register.RegisterApplication;
import com.meal.register.common.R;
import com.meal.register.entity.Registration;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.imageio.spi.RegisterableService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 登记记录表 服务类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
public interface IRegistrationService extends IService<Registration> {

    Integer addRegister(Registration registration);

    Integer deleteRegister(Registration registration);

    void selectPage(Page<Registration> page, Registration registration, LocalDateTime startDate, LocalDateTime endDate);

    Registration getObj(Registration registration);

}
