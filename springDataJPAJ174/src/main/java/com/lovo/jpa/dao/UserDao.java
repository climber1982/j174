package com.lovo.jpa.dao;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface UserDao extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity where age>?1")
    public List<UserEntity> getListUserByAge(int age);

    @Query("from UserEntity where age>:age2")
    public List<UserEntity> getListUserByAgeParam(@Param("age2") int age);
    //DTO
    @Query("select new com.lovo.jpa.dto.UserDto(userName,age) from " +
            " UserEntity")
    public  List<UserDto> getListDTO();
    //MAP
    @Query("select new map(userName,age) from UserEntity")
    public List<Map> getListMap();
       //分页
     @Query(value = "from UserEntity where age>?1")
     public List<UserEntity> getPageList(int age, PageRequest pageable);

     //SQL
     @Query(value = "select * from sys_user where age=?1",nativeQuery = true)
     public  List<UserEntity> getSQLList(int age);

    @Query(value = "select u_name,password from sys_user where age=:age",nativeQuery = true)
     public List<Object[]> getSqlObjectArray(@Param("age")int age);

    //删除
    @Query("delete  from UserEntity where userName=?1")
    @Modifying
    public  int delUserByName(String userName);
    //修改
    @Query("update  from UserEntity set age=32 where userName=?1")
    @Modifying
    public  int updateUserByName(String  userName);
   //from UserEntity where userName=? or age=?
    public List<UserEntity> findByUserNameOrAge(String userName,int age);
}
