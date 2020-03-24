package com.jpa;

import com.lovo.jpa.dao.BasicDao;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JPATest {
    @Test
    public  void test(){
        ClassPathXmlApplicationContext app=
                new ClassPathXmlApplicationContext("application.xml");
       BasicDao dao= (BasicDao) app.getBean("basicDao");
        System.out.println(dao.getEntityManager());
    }
}
