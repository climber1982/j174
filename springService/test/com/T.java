package com;

import com.lovo.ss.dao.IUserDao;
import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.service.IUserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class T {

   @Test
    public  void test(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
        IUserService service= (IUserService) context.getBean("userService");
        UserEntity u= service.getUserByName("zy");
       System.out.println(u);

    }
    @Test
    public void t(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
        IUserService service= (IUserService) context.getBean("userService");
         UserEntity userEntity=new UserEntity();
         userEntity.setUserName("赵云2");
         userEntity.setAge(20);
         userEntity.setPassword("12345");
          service.upadteUser(userEntity);
    }

}
