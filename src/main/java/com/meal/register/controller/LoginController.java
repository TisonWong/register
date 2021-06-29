package com.meal.register.controller;

import com.meal.register.entity.Members;
import com.meal.register.service.IMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IMembersService membersService;


    @RequestMapping("/index")
    public String loginIndex(){
        return "login/login";
    }


    @RequestMapping("/check")
    public String check(@RequestParam("memberName") String memberName,@RequestParam("memberPwd") String memberPwd, Model model, HttpSession session){

        Members members = new Members();
        members.setMemberName(memberName);
        members.setMemberPwd(memberPwd);

        System.err.println(members.toString());

        String url = "";
        if(null != session.getAttribute("url")){
            url = (String) session.getAttribute("url");
        }else {
            url = "/admin/list";
        }

        if(membersService.checkMemberPwd(members)){
            session.setAttribute("member",members);
            return "redirect:"+url;
        }else {
            model.addAttribute("message","用户名或密码错误");
            return "login/login";
        }
    }
}
