package com.jpa;

import com.lovo.jpa.dao.BasicDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class JPATest {
    BasicDao dao=null;
    @Before
    public  void test(){
        ClassPathXmlApplicationContext app=
                new ClassPathXmlApplicationContext("application.xml");
        dao= (BasicDao) app.getBean("basicDao");

    }
    @Test
    public  void HQL(){
        List<UserEntity> list=dao.findListHQL();
        System.out.println(list.size());
    }
   @Test
    public  void getObject(){
      UserEntity user=  dao.findUserEntity();
        System.out.println(user.getUserName());
    }
    @Test
    public  void getObject2(){
        UserEntity user=  dao.findUserEntity2();
        System.out.println(user.getUserName());
    }
    @Test
    public void getListDto(){
        List<UserDto> list= dao.findListDto();
        System.out.println(list.size());
    }
    @Test
    public void getListMap(){
        List<Map> list= dao.findListMap();
        System.out.println(list.size());
    }
    @Test
    public  void getListSql(){
      List<UserEntity> list=  dao.getListSQL();
        System.out.println(list);
    }
    @Test
    public void getMapSql(){
        List<Map> list=dao.getListMap();
        System.out.println(list.size());
    }
}
