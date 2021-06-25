package com.meal.register.service.impl;

import com.meal.register.entity.Departments;
import com.meal.register.mapper.DepartmentsMapper;
import com.meal.register.service.IDepartmentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Service
public class DepartmentsServiceImpl extends ServiceImpl<DepartmentsMapper, Departments> implements IDepartmentsService {

    @Override
    public List<Departments> selectAll() {
        return baseMapper.selectList(null);
    }
}
