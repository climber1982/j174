package com.lovo.jpa.dao;

import org.hibernate.engine.spi.Managed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Transactional
@Repository(value = "basicDao")
public class BasicDao {
   @Autowired
   private LocalContainerEntityManagerFactoryBean managerFactoryBean;
    public EntityManager getEntityManager(){
        //获得工厂
        EntityManagerFactory managerFactory=
        managerFactoryBean.getNativeEntityManagerFactory();

        return  managerFactory.createEntityManager();
    }
}
