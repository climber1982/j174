package com;

import com.lovo.sh.dao.BasicDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestHibernate {
    ClassPathXmlApplicationContext context=null;
    IUserService userService=null;
    @Before
    public  void before(){
      context
                =new ClassPathXmlApplicationContext("application.xml");
        userService= (IUserService) context.getBean("userService");
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

        UserEntity userEntity=new UserEntity();

        userEntity.setAddDate("2020-03-23");
        userEntity.setUserName("赵云2");
        userEntity.setAge(30);
     userService.savaUser(userEntity);
    }
   @Test
    public void delObject(){
        userService.delUser("4028808e710655b101710655b6f20000");
//        UserEntity userEntity=new UserEntity();
//        userEntity.setUserId(4);
//         userEntity.setUserName("赵云2");
//
//
//        userService.delUser(userEntity);

     //  userService.delUser();
    }
    @Test
    public  void findAll(){
    List<UserEntity> list=    userService.findAll();
    for (UserEntity userEntity:list){
        System.out.println(userEntity.getUserName());
    }
    }
}
