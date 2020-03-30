package com.lovo.spring.util;

import com.lovo.spring.dto.PowerDto;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Myinterceptor implements HandlerInterceptor {
    //预处理
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          boolean bl=false;
          //判断用户是否登录，如果没有登录就返回到登录界面
     Object obj=   request.getSession().getAttribute("userObj");
     if(null!=obj){
         //如果登录，判断用户是否拥有权限
         List<PowerDto>listPower=
                 (List<PowerDto>) request.getSession().getAttribute("listPower");
          //获得用户访问权限
        String path= request.getServletPath();
        if(null!=path&&path.length()>0){
            path=path.substring(1,path.length());
        }
         for (PowerDto dto:listPower) {
             if(dto.getPowerUri().equals(path)){
                 //找打了访问资源
                 bl=true;//放行
                 break;
             }
         }
     }else{
         //未登录
         response.sendRedirect("index.jsp");
     }
       if(!bl){
           //没有权限-->登录
           response.sendRedirect("index.jsp");
       }

        return bl;
    }

    //controller方法执行完，但是视图 还没有渲染
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //视图渲染完成
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
