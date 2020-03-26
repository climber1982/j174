package com.lovo.jpa.service;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

public interface IUserService {

    public List<UserEntity> getListUserByAge(int age);
    public List<UserEntity> getListUserByAgeParam(int age);
    public  List<UserDto> getListDTO();

    public List<Map> getListMap();

    public  UserEntity savaUser(UserEntity user);

    public  List<UserEntity> findList();

    public  UserEntity getUserById(String id);
    public  void delUserById(String id);

    public void savaList(List<UserEntity> list);

    public List<UserEntity> getPageList(int age , PageRequest paeable);

    public  List<UserEntity> getSQLList(int age);

    public List<UserEntity> getSqlObjectArray(int age);

    public  int delUserByName(String userName);

    public  int updateUserByName(String userName);
    public List<UserEntity> findByUserNameOrAge(String userName,int age);
}
