package com.meal.register.controller;

import com.meal.register.common.R;
import com.meal.register.entity.Members;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public String loginIndex(){
        return "login/login";
    }


    @RequestMapping("/index2")
    public String loginIndex2(){
        return "login/login2";
    }

    @ResponseBody
    @RequestMapping("/check")
    public R check(Members members){
        System.err.println(members.toString());
        return R.ok();
    }
}
