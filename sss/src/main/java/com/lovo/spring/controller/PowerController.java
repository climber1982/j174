package com.lovo.spring.controller;

import com.lovo.spring.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PowerController {

    @RequestMapping("add.lovo")
    public ModelAndView add(){
          ModelAndView mv=new ModelAndView("show");
          mv.addObject("powerInfo", StringUtil.ADDINFO);
          return mv;
    }
    @RequestMapping("del.lovo")
    public ModelAndView del(){
        ModelAndView mv=new ModelAndView("show");
        mv.addObject("powerInfo", StringUtil.DELINFO);
        return mv;
    }
    @RequestMapping("find.lovo")
    public ModelAndView find(){
        ModelAndView mv=new ModelAndView("show");
        mv.addObject("powerInfo", StringUtil.FINDINFO);
        return mv;
    }
}
