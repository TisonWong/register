package com.meal.register.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meal.register.common.R;
import com.meal.register.entity.Registration;
import com.meal.register.entity.dto.RegistrationDto;
import com.meal.register.service.IRegistrationDtoService;
import com.meal.register.service.IRegistrationService;
import com.meal.register.util.MyTool;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员接口
 */
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private MyTool myTool;

    @Autowired
    private IRegistrationService registrationService;

    @Autowired
    private IRegistrationDtoService registrationDtoService;

    @RequestMapping("/list")
    public String getListPage(Model model){
        LocalDate toDay = LocalDate.now();

        model.addAttribute("toDay",toDay);
        return "register/registerList";
    }

    @RequestMapping("/monthList")
    public String getMonthListPage(Model model){
        LocalDate localDateNow = LocalDate.now();

        model.addAttribute("firstDayOfMonth",localDateNow.with(TemporalAdjusters.firstDayOfMonth()));
        model.addAttribute("lastDayOfMonth",localDateNow.with(TemporalAdjusters.lastDayOfMonth()));
        return "register/registerMonthList";
    }

    @RequestMapping("/pageTable")
    @ResponseBody
    public Map<String,Object> getPageTable(@Param("pageSize")Long pageSize ,@Param("pageNumber")Long pageNumber ,@Param("searchText") String searchText,@Param("startDate")String startDate, @Param("endDate")String endDate){

        if(null == pageNumber || null == pageSize){
            pageNumber = 1L;
            pageSize = 20L;
        }

        Page<Registration> registrationPage = new Page<>(pageNumber,pageSize);

        registrationService.selectPage(registrationPage, searchText, startDate, endDate);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",registrationPage.getTotal());
        resultMap.put("rows",registrationPage.getRecords());

        return resultMap;
    }

    @RequestMapping("/monthPageTable")
    @ResponseBody
    public Map<String,Object> getMonthPageTable(@Param("pageSize")Long pageSize ,@Param("pageNumber")Long pageNumber ,@Param("searchText") String searchText,@Param("startDate")String startDate, @Param("endDate")String endDate){

        if(null == pageNumber || null == pageSize){
            pageNumber = 1L;
            pageSize = 20L;
        }

        Page<RegistrationDto> registrationPage = new Page<>(pageNumber,pageSize);

        registrationDtoService.selectMonthPage(registrationPage, searchText, startDate, endDate);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",registrationPage.getTotal());
        resultMap.put("rows",registrationPage.getRecords());

        return resultMap;
    }

}
