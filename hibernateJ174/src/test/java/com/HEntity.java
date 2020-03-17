package com;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

public class HEntity {

    Session session=null;
    @Before
       public void before(){
          session= HSession.createSession();
       }
        @Test
       public  void savaRole(){
            //瞬时状态
            RoleEntity r=new RoleEntity();
            r.setRoleName("教师");
           //操作数据库
        Transaction tr= session.getTransaction();

        tr.begin();
            /***持久状态**/
            session.save(r);
            //操作持久状态
            r.setRoleName("学生");

        tr.commit();
            /***持久状态**/
        session.close();
        /****游离状态***/

       }

       @Test
       public  void testRole(){
     Transaction  tr=   session.getTransaction();
     tr.begin();
        //持久状态
           RoleEntity roleEntity=     session.get(RoleEntity.class,"4028808e70e654ea0170e654f12b0000");
         //改变持久状态
           roleEntity.setRoleName("教师");
           tr.commit();
           session.close();
    }
    //急加载
    @Test
     public  void get(){
        RoleEntity roleEntity=     session.get(RoleEntity.class,"4028808e70e654ea0170e654f12b0000");
       // System.out.println("session关闭之前"+roleEntity.getRoleName());
         session.close();
        System.out.println("session关闭之后"+roleEntity.getRoleName());
    }
    //懒加载
    @Test
    public  void load(){
        RoleEntity roleEntity=     session.load(RoleEntity.class,"4028808e70e654ea0170e654f12b0000");
      // System.out.println("session关闭之前"+roleEntity.getRoleName());
        //一级缓存
        session.close();
        //一级缓存就没了
        System.out.println("session关闭之后"+roleEntity.getRoleName());
    }
}
