package com.meal.register.controller;


import com.meal.register.common.R;
import com.meal.register.entity.Departments;
import com.meal.register.service.IDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private IDepartmentsService departmentsService;


}
