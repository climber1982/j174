package com;

import com.lovo.ss.dao.IUserDao;
import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class T {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
      IUserService userDao= (IUserService) context.getBean("userService");
        List<UserEntity> list= userDao.getListUser();
        for (UserEntity u:list
        ) {
            System.out.println(u.getAge());
        }
    }

    public  void test(){

    }
}
