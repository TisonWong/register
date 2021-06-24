package com.meal.register.controller;

import com.meal.register.entity.Members;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public String loginIndex(){
        return "login/login";
    }


    @RequestMapping("/check")
    public String check(Members members, Model model, HttpServletRequest httpServletRequest){

        if(null==members){
            System.err.println("登录失败");
            model.addAttribute("message","用户名或密码不正确");
            return "login/login";
        }else{
            System.err.println("登录成功："+members.toString());
            httpServletRequest.setAttribute("member",members.getMemberId());
            return "redirect:/registration/index";
        }

    }
}
