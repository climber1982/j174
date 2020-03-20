package com;

import com.lovo.hibernate.dto.TeacherDto;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class HQL {

    Session session=null;
    Transaction tr= null;
    @Before
    public void before(){
        session= HSession.createSession();
        tr= session.getTransaction();
        tr.begin();
    }

    @Test
   public void hql1(){
        String hql="select t from TeacherEntity t";
     //获得query对象
    Query query= session.createQuery(hql);
    //查询所以
     List<Object> list=   query.list();
      for(Object obj:list){
          System.out.println(
           ((TeacherEntity)obj).getTeacherName());
      }
   }
    @Test
    public void hql2(){
        String hql="from TeacherEntity";
   List<TeacherEntity> list=
        session.createQuery(hql)
                .list();
       for(TeacherEntity t:list){
           System.out.println(t.getTeacherName()+"/"+t.getTeacherClass());
       }
    }

    @Test
    public  void hql3(){

       String hql="from TeacherEntity where teacherClass=?";
     List<TeacherEntity> list=
       session.createQuery(hql)
               .setParameter(0,"JAVA")//替换占位符
               .list();
        for(TeacherEntity t:list){
            System.out.println(t.getTeacherName()+"/"+t.getTeacherClass());
        }
    }

    @Test
    public void hql4(){
        String hql="select teacherName,teacherClass from TeacherEntity where teacherClass=?";
        List<Object[]> list=
         session.createQuery(hql)
                 .setParameter(0,"JAVA")
                 .list();
        for(Object[] objs:list){
            System.out.println(objs[0].toString()+"/"+objs[1].toString());
        }
    }
    @Test
    public void hql5(){
        String hql="select new com.lovo.hibernate.dto.TeacherDto(teacherName,teacherClass) " +
                "from TeacherEntity where teacherClass=?";
        List<TeacherDto> list=
          session.createQuery(hql)
                  .setParameter(0,"JAVA")
                  .list();
        for (TeacherDto dto:list){
            System.out.println(dto.getUserName()+"/"+dto.getUserClass());
        }
    }

    @Test
    public void hql6(){
        String hql="select new map(teacherName,teacherClass) " +
                "from TeacherEntity where teacherClass like ?";
        List<Map> list=
                session.createQuery(hql)
                        .setParameter(0,"JA%")
                        .list();
         for(Map map:list){
             System.out.println(map.get("0")+"/"+map.get("1"));
         }
    }
    @Test
    public void hql7(){
        String hql="select new map(s.studentName,t.teacherName,t.teacherClass) " +
                "from StudentEntity s " +
                " left join s.teacher t where t.teacherName=?";
         List<Map> list=
           session.createQuery(hql)
                   .setParameter(0,"陈老师")
                   .list();
        System.out.println(list.size());
    }
    //分页查询
    @Test
    public void hql8(){
        int currentpage=2;
        int pageCount=5;
        String hql="from TeacherEntity where teacherName like ?";
        List<TeacherEntity> list=
                session.createQuery(hql)
                .setParameter(0,"薛%")
                .setFirstResult((currentpage-1)*pageCount) //起始位置
                .setMaxResults(pageCount) //每页显示的行数
                .list();
        for (TeacherEntity t:list){
            System.out.println(t.getTeacherName());
        }
    }
    //查询对象
    @Test
    public void hql9(){
        String hql="from TeacherEntity where teacherName=?";
      TeacherEntity t=
              (TeacherEntity) session.createQuery(hql)
                      .setParameter(0,"陈老师")
                      .uniqueResult();
        System.out.println(t.getTeacherClass());
    }

    //删除
    @Test
    public  void hql10(){
        String hql="delete from TeacherEntity where teacherName=?";
     int i=   session.createQuery(hql)
                .setParameter(0,"薛老师19")
                .executeUpdate(); //执行修改、删除返回受影响的行数
        System.out.println(i);
    }
    //修改
    @Test
    public  void hql11(){
      String hql="update TeacherEntity set teacherClass=? where teacherName=?";
     int i= session.createQuery(hql)
              .setParameter(0,"WEB2")
              .setParameter(1,"薛老师18")
              .executeUpdate();
        System.out.println(i);
    }







    @After
    public void after(){
        tr.commit();
        session.close();
    }
}
