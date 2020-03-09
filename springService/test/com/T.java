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
        IUserService userDao= (IUserService) context.getBean("userService");
        List<UserEntity> list= userDao.getListUser();
        for (UserEntity u:list) {
            System.out.println(u.getAge());
        }
    }
}
