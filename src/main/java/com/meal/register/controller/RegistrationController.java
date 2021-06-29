package com.meal.register.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meal.register.entity.Departments;
import com.meal.register.entity.Registration;
import com.meal.register.service.IDepartmentsService;
import com.meal.register.service.IRegistrationService;
import com.meal.register.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 登记记录表 前端控制器
 * </p>
 *
 * @author Tison
 * @since 2021-06-24
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController{

    @Autowired
    private MyTool myTool;

    @Autowired
    private IRegistrationService registrationService;

    @Autowired
    private IDepartmentsService departmentsService;

    @RequestMapping("/index")
    public String getPage(Model model){

        model.addAttribute("dinnerDate",myTool.getNextDay());

        List<Departments> departments = departmentsService.selectAll();
        model.addAttribute("departments",departments);

        return "register/register";
    }

    @ResponseBody
    @PostMapping("/register")
    public String register(@RequestParam("memberName") String memberName, @RequestParam("departmentName") String departmentName){

        Registration registration = new Registration();
        registration.setMemberName(memberName);
        registration.setDepartmentName(departmentName);


        Registration obj = registrationService.getObj(registration);
        if(null != obj){
            return "您已预约了【"+myTool.getNextDay()+"】，请勿重复提交。";
        }

        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        if(hour>=17){
            return "预约失败，已经过了预约时间";
        }

        registration.setDinnerDate(myTool.getNextDay());
        registrationService.addRegister(registration);

        return "预约成功【"+myTool.getNextDay()+"】。";
    }



}
