package com;

import com.lovo.hibernate.entity.RoleEntity;
import com.lovo.hibernate.entity.UserEntity;
import com.lovo.hibernate.util.HSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.management.relation.Role;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestH {
     @Test
    public  void  test2()
     {
         System.out.println(HSession.createSession());
    }

    @Test
    public  void savaUser(){
        UserEntity user=new UserEntity();
       user.setUserName("赵云");
        user.setPassword("12345");
        user.setAge(30);
        String str="mysql中的text对应oracle中的clob\n" +
                "又分为TINYTEXT, TEXT, MEDIUMTEXT,LONGTEXT, 都是表示数据长度类型的一种。\n" +
                "语法：[ UNSIGNED ] mediumtext\n" +
                "TINYTEXT: 256 bytes\n" +
                "TEXT: 65,535 bytes => ~64kb\n" +
                "MEDIUMTEXT: 16,777,215 bytes => ~16MB\n" +
                "LONGTEXT: 4,294,967,295 bytes => ~4GB\n" +
                "\n" +
                "当字节如果太大一般用Medimtext，慎用longText，为什么？\n" +
                "\n" +
                "假如突然来了一个错误数据，非常大，而这个表如果是跑任务，（一晚，就一晚可能你的服务器就爆了，连登录服务器都成了问题）\n" +
                "\n" +
                "然后如果真的没办法要用longtext，这个类型，正式环境请保存前\n" +
                "————————————————\n" +
                "版权声明：本文为CSDN博主「Joker_Ye」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\n" +
                "原文链接：https://blog.csdn.net/hj7jay/article/details/87968144";
        user.setInfo(str);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
       String date= sdf.format(new Date());
        user.setAddDate(date);
        //获得session
     Session  s= HSession.createSession();
      //获取事务
     Transaction tr= s.getTransaction();
     //开启事务
        tr.begin();
        //执行保存
        s.save(user);
        //提交事务
        tr.commit();
        //关闭session
        s.close();
    }
    @Test
    public void getUser(){
        //获得session
        Session  s= HSession.createSession();
     UserEntity user=   s.get(UserEntity.class,1);
        System.out.println(user.getUserName());
        s.close();
    }
    @Test
    public  void updateUser(){
        //获得session
        Session  s= HSession.createSession();
        //获取事务
        Transaction tr= s.getTransaction();
        //开启事务
        tr.begin();
        //查询
        UserEntity user=   s.get(UserEntity.class,1);
        user.setAge(100);
        //修改
        s.update(user);
        tr.commit();
        s.close();
    }
    @Test
    public void delUser(){
        //获得session
        Session  s= HSession.createSession();
        //获取事务
        Transaction tr= s.getTransaction();
        //开启事务
        tr.begin();
        UserEntity user=new UserEntity();
        user.setUserId(1);
        s.delete(user);
        tr.commit();
        s.close();
    }

    @Test
    public  void savaRole(){
        //获得session
        Session  s= HSession.createSession();
        //获取事务
        Transaction tr= s.getTransaction();
        for(int i=0;i<10;i++) {
        tr.begin();

            RoleEntity r = new RoleEntity();
            r.setRoleName("管理员"+i);
            s.save(r);
            tr.commit();
        }
        s.close();
    }



}
