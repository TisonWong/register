package com.meal.register.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meal.register.common.R;
import com.meal.register.entity.Registration;
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

    @RequestMapping("/list")
    public String getListPage(Model model){
        model.addAttribute("toDay",LocalDate.now());
        return "register/registerList";
    }

    @RequestMapping("/pageTable")
    @ResponseBody
    public Map<String,Object> getPageTable(@Param("pageSize")Long pageSize ,@Param("pageNumber")Long pageNumber ,@Param("searchText") String searchText,@Param("startDate")String startDate, @Param("endDate")String endDate){

        LocalDateTime startLocalDateTime = null;
        LocalDateTime endLocalDateTime = null;
        if(!startDate.isEmpty()){
            startLocalDateTime = LocalDateTime.of(LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE), LocalTime.of(0,0));
        }if(!endDate.isEmpty()){
            endLocalDateTime = LocalDateTime.of(LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE),LocalTime.of(23,59));
        }

        System.err.println("searchText:"+searchText+",start:"+startLocalDateTime+",end:"+endLocalDateTime);

//        Map<String, LocalDateTime> queryDate = myTool.getQueryDate();
//        IPage<Registration> registrationIPage = registrationService.selectPage(offset, limit, null, queryDate.get("startDate"), queryDate.get("endDate"));
        Page<Registration> registrationPage = new Page<>(pageNumber,pageSize);
        registrationService.selectPage(registrationPage, null, startLocalDateTime, endLocalDateTime);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",registrationPage.getTotal());
        resultMap.put("rows",registrationPage.getRecords());

        return resultMap;
    }

}
