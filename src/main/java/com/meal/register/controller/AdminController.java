package com.meal.register.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meal.register.entity.Registration;
import com.meal.register.service.IRegistrationService;
import com.meal.register.util.MyTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
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

        Map<String, LocalDateTime> queryDate = myTool.getQueryDate();

        IPage<Registration> registrationIPage = registrationService.selectPage(1L, 10000L, null, queryDate.get("startDate"), queryDate.get("endDate"));
        model.addAttribute("list",registrationIPage.getRecords());
        model.addAttribute("total",registrationIPage.getTotal());

        return "register/registerList";
    }

}
