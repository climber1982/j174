package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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

    /**
     * 根据ID获取对象
     * @param id
     * @return
     */
    public  T getObjectById(String id){
         return
                 this.getCurrentSession()
                 .get(cl,id);
    }

    public List<T> getListByArray(String hql,Object[] objs){
        Query query= this.getCurrentSession().createQuery(hql);
        for(int i=0;i<objs.length;i++){
            query.setParameter(i,objs[i]);
        }
      return   query.list();
    }


    public  void test(){
       Session s= this.getOpenSession();
        Transaction tx=  s.getTransaction();
        tx.begin();
        UserEntity user=
       s.get(UserEntity.class,"4028808e710658120171065817a50000");
        System.out.println(user.getUserName());
        try {
            Thread.sleep(1000*10);
            s.clear(); //清空缓存
            s.flush();//刷新缓存
            tx.commit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserEntity user2=
                s.get(UserEntity.class,"4028808e710658120171065817a50000");
        System.out.println(user2.getUserName());
        UserEntity user3=
                s.get(UserEntity.class,"4028808e710658120171065817a50000");
        System.out.println(user3.getUserName());

        s.close();

    }
}
