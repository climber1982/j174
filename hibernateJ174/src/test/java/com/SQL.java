package com;

import com.lovo.hibernate.dto.TeacherDto;
import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
    public  void sql1_1(){
        String sql="select t.*,s.* from sys_teacher t " +
                " left join sys_student s on t.t_id=s.f_t_id " +
                " where t_name=?";
        List<Object[]> list=
        session.createNativeQuery(sql)
                .addEntity("t",TeacherEntity.class)
                .addEntity("s", StudentEntity.class)
                .setParameter(1,"陈老师")
                .list();
      for (Object[] objs:list){
          TeacherEntity t=    (TeacherEntity)objs[0];
          StudentEntity s=(StudentEntity)objs[1];
          System.out.println(t.getTeacherName()+"/"+s.getStudentName());
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

    @Test
    public  void sql3(){
        String sql="select t_name,t_class  from sys_teacher " +
                "  where t_class=?";
        List<Map> list=
       session.createNativeQuery(sql)
               .setParameter(1,"JAVA")
               .unwrap(NativeQueryImpl.class)  //拆包
               .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
               .list();
        for (Map map:list){
            System.out.println(map.get("t_name")+"/"+map.get("t_class"));
        }
    }
    @Test
    public  void sql4(){
        String sql="select t_name as userName ,t_class as userClass  from sys_teacher " +
                "  where t_class=?";
        List<TeacherDto> list=
                session.createNativeQuery(sql)
                        .setParameter(1,"JAVA")
                        .unwrap(NativeQueryImpl.class)  //拆包
                        .setResultTransformer
                                (Transformers.aliasToBean(TeacherDto.class))
                        .list();
        for(TeacherDto dto:list){
            System.out.println(dto.getUserName());
        }
    }
    @Test
    public  void sql5(){
        String sql="select t.t_name,t.t_class,s.s_name from sys_teacher t " +
                " left join sys_student s on t.t_id=s.f_t_id " +
                " where t_name=?";
        List<Map> list=
        session.createNativeQuery(sql)
                .setParameter(1,"陈老师")
                .unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();

        for(Map map:list){
            System.out.println(map.get("t_name")+","+map.get("s_name"));
        }
    }
    @Test
    public  void sql6(){
         String sql="select * from sys_teacher";
         List<TeacherEntity> list=
         session.createNativeQuery(sql)
                 .addEntity(TeacherEntity.class)
                 .setFirstResult(10)
                 .setMaxResults(10)
                 .list();
         for(TeacherEntity t:list) {
             System.out.println(t.getTeacherName());
         }
    }
// 查询1行
    @Test
    public  void sql7(){
        String sql="select * from sys_teacher where t_class=?";
        TeacherEntity t=
                (TeacherEntity) session.createNativeQuery(sql)
                        .addEntity(TeacherEntity.class)
                        .setParameter(1,"JAVA")
                        .uniqueResult();//查询结果只能有1个，否则会报NonUniqueResultException
        System.out.println(t.getTeacherName());
    }

    //删除
    @Test
    public  void sql8(){
        String sql="delete from sys_teacher where t_name=?";
       int count=
        session.createNativeQuery(sql)
                .setParameter(1,"薛老师18")
                .executeUpdate();
        System.out.println(count);
    }
  //修改
    @Test
    public  void sql9(){
        String sql="update sys_teacher set t_class=? where t_name=?";
        int count=
                session.createNativeQuery(sql)
                .setParameter(1,"J2EE2")
                .setParameter(2,"陈老师")
                .executeUpdate();
    }

    @After
    public void after(){
        tr.commit();
        session.close();
    }
}
