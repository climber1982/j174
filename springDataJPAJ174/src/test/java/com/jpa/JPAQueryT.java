package com.jpa;

import com.lovo.jpa.dao.BasicDao;
import com.lovo.jpa.dao.UserDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.ArrayList;
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
    public void savaUserList(){
      List<UserEntity> list=new ArrayList<>();
      for(int i=0;i<15;i++){
          UserEntity user=new UserEntity();
          user.setAge(30);
          user.setUserName("马超"+i);
          user.setPassword("mc12345"+i);
          list.add(user);
      }
       userService.savaList(list);
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
    @Test
    public void getPageList(){
        PageRequest pageable=PageRequest.of(1,5);
      List<UserEntity>  list= userService.getPageList(10,pageable);
        System.out.println(list.size());
    }
    @Test
    public void  getSQLList(){
     List<UserEntity> list=   userService.getSQLList(30);
        System.out.println(list.size());
    }
    @Test
    public void getSqlObjectArray(){
        List<UserEntity> list=   userService.getSqlObjectArray(30);
        System.out.println(list.size());
    }
    @Test
    public  void delUserByName(){
     int i=   userService.delUserByName("马超");
        System.out.println(i);
    }
   @Test
    public  void upateUserByName(){
        userService.updateUserByName("马超0");
    }
    @Test
    public  void findByUserNameOrAge(){
     List<UserEntity> list=    userService.findByUserNameOrAge("马超",30);
        System.out.println(list.size());
    }
}

