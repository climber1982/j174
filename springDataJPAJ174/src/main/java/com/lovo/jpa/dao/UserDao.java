package com.lovo.jpa.dao;

import com.lovo.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity where age>?1")
    public List<UserEntity> getListUserByAge(int age);
}
