package com;

import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SQL {
    Session session=null;
    Transaction tr= null;
    @Before
    public void before(){
        session= HSession.createSession();
        tr= session.getTransaction();
        tr.begin();
    }
    @Test
    public  void sql1(){

        String sql="select *  from sys_teacher";
        NativeQuery query= session.createNativeQuery(sql);
        query.addEntity(TeacherEntity.class); //把查询出来的数据放入实体中，被hibernate管理的实体
      List<TeacherEntity> list= query.list();
      for (TeacherEntity t:list){
          System.out.println(t.getTeacherName());
      }
    }

    @Test
    public  void sql2(){

        String sql="select t_name,t_class  from sys_teacher";
       List<Object[]> list=  session.createNativeQuery(sql)
                 .list();
       for(Object[] objs:list){
           System.out.println(objs[0]+"/"+objs[1]);
       }
    }

    @After
    public void after(){
        tr.commit();
        session.close();
    }
}
