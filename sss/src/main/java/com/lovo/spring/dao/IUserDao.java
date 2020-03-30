package com.lovo.spring.dao;

import com.lovo.spring.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUserDao extends CrudRepository<UserEntity,Integer> {

    public UserEntity findByUserNameAndPassword(String userName,String password);

    /**
     * 根据名字查询出权限集合
     * @param userName 名字
     * @return
     */
    @Query(value = "select u.u_name,p.p_name,p.p_uri from sys_user u  left join " +
            " sys_role_user ru on u.userId=ru.f_u_id " +
            " left join sys_role r on r.roleId=ru.f_r_id " +
            " left join sys_role_power rp on rp.r_id=r.roleId " +
            " left join sys_power p on rp.p_id=p.powerId where u.u_name=?1",nativeQuery = true)
    public List<Object[]> findPowerByUserName(String userName);
}
