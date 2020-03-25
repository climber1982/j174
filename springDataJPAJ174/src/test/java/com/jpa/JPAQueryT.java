package com.jpa;

import com.lovo.jpa.dao.BasicDao;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JPAQueryT {
    IUserService userService=null;
    @Before
    public  void test(){
        ClassPathXmlApplicationContext app=
                new ClassPathXmlApplicationContext("application.xml");
        userService= (IUserService) app.getBean("userService");

    }

    @Test
    public void testHQLfind(){
        List<UserEntity> list=
        userService.getListUserByAge(10);
        System.out.println(list.size());
    }
}
