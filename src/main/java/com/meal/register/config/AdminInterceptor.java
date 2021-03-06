package com.meal.register.config;

import com.meal.register.entity.Members;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURL().toString();
        request.getSession().setAttribute("URL",url);

        Members member = (Members) request.getSession().getAttribute("member");
        if(null!=member){
            return true;
        }

        if (url.contains("admin")){
            response.sendRedirect(request.getContextPath()+"/login/index");
            return false;
        }

        response.sendRedirect(request.getContextPath()+"/registration/index");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
