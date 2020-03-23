package com.lovo.sh.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;
@Repository(value = "basicDao")
public class BasicDao {

    @Autowired
  private LocalSessionFactoryBean localSessionFactoryBean;
    //hibernate提供的session
    public  Session getOpenSession(){
     return    localSessionFactoryBean.getObject().openSession();
    }
    //是被spring管理的session,需要spring的事务支持，关闭session由spring来完成

    public Session getCurrentSession(){
        return  localSessionFactoryBean.getObject().getCurrentSession();
    }
}
