package com.meal.register.service;

import com.meal.register.entity.Departments;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
public interface IDepartmentsService extends IService<Departments> {

    List<Departments> selectAll();

}
