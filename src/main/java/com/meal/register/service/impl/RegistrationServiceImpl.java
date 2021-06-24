package com.meal.register.service.impl;

import com.meal.register.entity.Registration;
import com.meal.register.mapper.RegistrationMapper;
import com.meal.register.service.IRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
