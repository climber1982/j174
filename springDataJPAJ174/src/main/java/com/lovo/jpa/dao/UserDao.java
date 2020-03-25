package com.lovo.jpa.dao;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.junit.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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


}
