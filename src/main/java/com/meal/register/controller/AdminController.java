package com.meal.register.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

import java.time.LocalDateTime;
import java.util.Collections;
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
//        model.addAttribute("list",registrationIPage.getRecords());
//        model.addAttribute("total",registrationIPage.getTotal());
        return "register/registerList";
    }

    @RequestMapping("/pageTable")
    @ResponseBody
    public R getPageTable(@Param("offset")Long offset ,@Param("limit")Long limit){
        System.err.println(offset+","+limit);

//        Map<String, LocalDateTime> queryDate = myTool.getQueryDate();
//        IPage<Registration> registrationIPage = registrationService.selectPage(offset, limit, null, queryDate.get("startDate"), queryDate.get("endDate"));
        IPage<Registration> registrationIPage = registrationService.selectPage(offset, limit, null, null, null);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("total",registrationIPage.getTotal());
        resultMap.put("rows",registrationIPage.getRecords());
//        resultMap.put("offset",registrationIPage.getCurrent());
        return R.ok().data(resultMap);
    }

}
