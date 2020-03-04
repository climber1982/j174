package com.lovo.spring.t;

import com.lovo.spring.entity.TeacherEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    ClassPathXmlApplicationContext applicationContext=null;

    @Before
    public  void before(){
        //1、创建spring对象，把spring在内存中开辟一个空间,需要给spring指令
        //2、spring根据我们所给的指令，在容器创建出我们需要的对象
        applicationContext=new ClassPathXmlApplicationContext("application.xml");
    }

    @Test
    public  void testTeacher(){
       //3、从容器中获取我们需要的对象
    TeacherEntity t= (TeacherEntity) applicationContext.getBean("teacher");
        System.out.println(t);
    }
}
