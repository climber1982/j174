package com;

import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.entity.many.MStudentEntity;
import com.lovo.hibernate.entity.many.MTeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ORMT {
    Session session=null;
    Transaction tr= null;
    @Before
    public void before(){
        session= HSession.createSession();
        tr= session.getTransaction();
        tr.begin();
    }
    @Test
    public  void savaT(){
        for(int i=0;i<20;i++) {
            TeacherEntity t = new TeacherEntity();
            t.setTeacherName("薛老师"+i);
            t.setTeacherClass("WEB"+i);
            session.save(t);
        }

    }
    @Test
    public  void manytooneSave(){
        //获得教师
//        TeacherEntity t=
//        session.get(TeacherEntity.class,"4028808e70eb8d760170eb8d79c50000");
       TeacherEntity t=new TeacherEntity();
       t.setTeacherId("4028808e70eb9d670170eb9d6b7d0000");
        //保存3个学生
        StudentEntity  s1=new StudentEntity();
        s1.setStudentName("赵云");
        s1.setTeacher(t);

        StudentEntity  s2=new StudentEntity();
        s2.setStudentName("马超");
        s2.setTeacher(t);

        StudentEntity  s3=new StudentEntity();
        s3.setStudentName("林冲");
        s3.setTeacher(t);

        session.save(s1);
        session.save(s2);
        session.save(s3);

    }
   @Test
    public  void findManytoOne(){
       StudentEntity stu=
          session.get(StudentEntity.class,"4028808e70eb9e400170eb9e43670000");
       System.out.println(stu.getStudentName()+"对应的教师:"
               +stu.getTeacher().getTeacherName()+"所教的科目:"
             +stu.getTeacher().getTeacherClass());
    }
    @Test
     public void casaAdd(){
        //瞬时对象
        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("张老师");
        t.setTeacherClass("servlet");

        //保存3个学生
        StudentEntity  s1=new StudentEntity();
        s1.setStudentName("赵云1");
        s1.setTeacher(t);

        StudentEntity  s2=new StudentEntity();
        s2.setStudentName("马超2");
        s2.setTeacher(t);

        StudentEntity  s3=new StudentEntity();
        s3.setStudentName("林冲2");
        s3.setTeacher(t);

        //级联保存
        session.save(s1);
        session.save(s2);
        session.save(s3);

     }

     @Test
     public  void caseDel(){

        session.delete(session.get(StudentEntity.class,
                "4028808e70ec4e380170ec4e3c2d0000"));
     }

     @Test
     public  void onetoManyFind(){
         TeacherEntity teacher=
        session.get(TeacherEntity.class,
                "4028808e70eb9d670170eb9d6b7d0000");

         for (StudentEntity stu:teacher.getSetStus()){
             System.out.println(stu.getStudentName());
         }
     }
     @Test
     public  void savaManyToMany1(){
        //添加主表
         MTeacherEntity t=new MTeacherEntity();
         t.setTeacherName("陈老师");
         t.setTeacherClass("J2EE");

         Set<MStudentEntity> setS=new HashSet<MStudentEntity>();
         MTeacherEntity t2=new MTeacherEntity();
         t2.setTeacherName("张老师");
         t2.setTeacherClass("WEB");

         MStudentEntity s=new MStudentEntity();
         s.setStudentName("赵云");
         MStudentEntity s2=new MStudentEntity();
         s2.setStudentName("林冲");
         MStudentEntity s3=new MStudentEntity();
         s3.setStudentName("马超");


         setS.add(s);
         setS.add(s3);
         t.setStudentsets(setS);
         session.save(s);
         session.save(s3);
         session.save(t);

     }

     @Test
     public  void findManyToMany(){
         MTeacherEntity t=
        session.get(MTeacherEntity.class,"4028808e70f0ecdf0170f0ece59c0002");
        Set<MStudentEntity> sets=t.getStudentsets();
         for(MStudentEntity s:sets){
             System.out.println(t.getTeacherName()+"/"+s.getStudentName());
         }
     }



    @After
    public void after(){
        tr.commit();
        session.close();
    }
}
