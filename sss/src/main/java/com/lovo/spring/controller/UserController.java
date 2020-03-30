package com.lovo.spring.controller;

import com.lovo.spring.dto.PowerDto;
import com.lovo.spring.entity.UserEntity;
import com.lovo.spring.service.IUserService;
import com.lovo.spring.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("login")
    public ModelAndView login(String userName, String password, HttpServletRequest request){
        ModelAndView mv=new ModelAndView("list");
        //判断用户是否存在,如果不存在就返回登录页面
        UserEntity user=
        userService.findByUserNameAndPassword(userName, password);
        if(null!=user){
            //如果用户存在就把该用户放入到session,并查询出他的所有权限，放入到session
            //并把权限放入到ModelAndView，跳转到主页面
         request.getSession().setAttribute("userObj",user);
         //权限集合
         List<PowerDto> listPower=
         userService.findPowerListByName(user.getUserName());
            request.getSession().setAttribute("listPower",listPower);
          //跳转到主页面
          mv.addObject("listPower",listPower);
          mv.setViewName("list");
        }else {
            //用户不存在
            mv.addObject("info", StringUtil.LOGINERROR);
            mv.setViewName("index");
        }



        return  mv;
    }
}
