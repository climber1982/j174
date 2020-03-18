package com;

import com.lovo.hibernate.entity.StudentEntity;
import com.lovo.hibernate.entity.TeacherEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        TeacherEntity t=new TeacherEntity();
        t.setTeacherName("陈老师");
        t.setTeacherClass("J2EE");
        session.save(t);

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

    @After
    public void after(){
        tr.commit();
        session.close();
    }
}
