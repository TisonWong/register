package com.meal.register.service.impl;

import com.meal.register.entity.Members;
import com.meal.register.mapper.MembersMapper;
import com.meal.register.service.IMembersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Service
public class MembersServiceImpl extends ServiceImpl<MembersMapper, Members> implements IMembersService {

}
