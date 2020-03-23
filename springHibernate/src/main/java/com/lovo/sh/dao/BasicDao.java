package com.lovo.sh.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Properties;
@Repository(value = "basicDao")
public class BasicDao<T> {
    Class<T> cl=null;
    public BasicDao(){
       cl= ReflectUtils.getClassGenricType(this.getClass());
    }
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

    /**
     * 保存
     * @param t
     */
     public void  savaObject(T t){
           this.getCurrentSession().save(t);
     }

    /**
     * 删除
     * @param t
     */
     public  void delObject(T t){
         this.getCurrentSession().delete(t);
     }

    /**
     * 根据ID来删除
     * @param id
     */
     public  void delObjectById(String id){
       Object obj=  this.getCurrentSession().get(cl,id);
         this.getCurrentSession().delete(obj);
     }

    /**
     * 修改
     * @param t
     */
     public  void updateObject(T t){
         this.getCurrentSession().update(t);
     }

    /**
     * 查询所有
     * @return
     */
     public List<T> findAll(){
         String hql="from "+cl.getSimpleName();
      return    this.getCurrentSession()
                 .createQuery(hql)
                 .list();

     }
   //有条件的查询  参数，数组，map ，Strings
}
