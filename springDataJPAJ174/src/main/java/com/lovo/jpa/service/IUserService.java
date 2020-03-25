package com.lovo.jpa.service;

import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;

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
}
