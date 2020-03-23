package com;

import com.lovo.sh.dao.BasicDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHibernate {
    ClassPathXmlApplicationContext context=null;
    @Before
    public  void before(){
      context
                =new ClassPathXmlApplicationContext("application.xml");
    }
   @Test
    public  void test(){
        ClassPathXmlApplicationContext context
                =new ClassPathXmlApplicationContext("application.xml");
     BasicDao dao= (BasicDao) context.getBean("basicDao");
        System.out.println(dao.getOpenSession());
       System.out.println(dao.getCurrentSession());
    }
    @Test
    public void savaUser(){
     IUserService userService= (IUserService) context.getBean("userService");
        UserEntity userEntity=new UserEntity();
        userEntity.setAddDate("2020-03-23");
        userEntity.setUserName("赵云2");
        userEntity.setAge(20);
     userService.savaUser(userEntity);
    }
}
