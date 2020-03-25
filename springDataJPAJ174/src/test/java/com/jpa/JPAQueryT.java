package com.jpa;

import com.lovo.jpa.dao.BasicDao;
import com.lovo.jpa.dao.UserDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

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

    @Test
    public void testHQLfindParam(){
        List<UserEntity> list=
                userService.getListUserByAgeParam(10);
        System.out.println(list.size());
    }
   @Test
    public  void testgetListDTO(){
      List<UserDto> list=  userService.getListDTO();
       System.out.println(list.size());
    }
    @Test
    public void getListMap(){
     List<Map> list=  userService.getListMap();
        System.out.println(list.size());
    }

    @Test
    public  void getUserById(){
     UserEntity user=   userService.getUserById("4028808e7110985c0171109868000000");
        System.out.println(user.getUserName());
    }
    @Test
    public void updateUser(){
        UserEntity user=   userService.getUserById("4028808e7110985c0171109868000000");
        user.setUserName("马超");
        userService.savaUser(user);
    }

    @Test
    public  void savaUser(){
        UserEntity user=new UserEntity();
        user.setUserId("4028808e7110985c0171109868000000");
       user.setAge(30);
        user.setUserName("马超2");
        user.setPassword("mc12345");
        userService.savaUser(user);
    }
    @Test
    public  void findList(){
     List<UserEntity> list=   userService.findList();
        System.out.println(list.size());
    }
    @Test
    public  void delUserById(){
         userService.delUserById("4028808e710658120171065817a50000");
    }
}

