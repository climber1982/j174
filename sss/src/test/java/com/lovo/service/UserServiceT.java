package com.lovo.service;

import com.lovo.spring.dto.PowerDto;
import com.lovo.spring.entity.UserEntity;
import com.lovo.spring.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceT {
    IUserService userService=null;
    @Before
    public  void before(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
        userService= (IUserService) context.getBean("userService");
    }

    @Test
    public  void login(){
        UserEntity user=
        userService.findByUserNameAndPassword("zy","123456");
        System.out.println(user);
    }

    @Test
    public void findPowerList(){
     List<PowerDto> list=   userService.findPowerListByName("zf");
        System.out.println(list.size());
    }

}
