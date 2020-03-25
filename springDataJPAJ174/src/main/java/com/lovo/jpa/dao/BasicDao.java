package com.lovo.jpa.dao;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.hibernate.engine.spi.Managed;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

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

      public List<UserEntity> findListHQL(){
       String hql="from UserEntity where age>?1";
      return this.getEntityManager().createQuery(hql)
               .setParameter(1,10)
               .getResultList();

      }
      public UserEntity findUserEntity(){
       String hql="from UserEntity where userName=?1";
       return (UserEntity) this.getEntityManager()
               .createQuery(hql)
               .setParameter(1,"赵云4")
               .getSingleResult();
      }
    public UserEntity findUserEntity2(){
        String hql="from UserEntity where userName=:userName2";
        return (UserEntity) this.getEntityManager()
                .createQuery(hql)
                .setParameter("userName2","赵云4")
                .getSingleResult();
    }

    public List<UserDto> findListDto(){
        String hql="select new com.lovo.jpa.dto.UserDto(userName,age) " +
                " from UserEntity";
       return  this.getEntityManager()
               .createQuery(hql)
               .getResultList();
    }
    public List<Map> findListMap(){
        String hql="select new map(userName,age) " +
                " from UserEntity";
        return  this.getEntityManager()
                .createQuery(hql)
                .getResultList();
    }

    public List<UserEntity> getListSQL(){
       String sql="select * from sys_user where age>?1";
       EntityManager entityManager=this.getEntityManager();
        NativeQuery query  = (NativeQuery) entityManager.createNativeQuery(sql);
       query.addEntity(UserEntity.class);
        query.setParameter(1,10);
      return   query.getResultList();
    }
    public List<Map> getListMap(){
        String sql="select u_name,age from sys_user where age>?1";
        return  this.getEntityManager()
                .createNativeQuery(sql)
                .setParameter(1,10)
                .unwrap(NativeQueryImpl.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
                .list();

    }

}
