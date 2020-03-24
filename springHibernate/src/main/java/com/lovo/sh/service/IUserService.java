package com.lovo.sh.service;

import com.lovo.sh.entity.UserEntity;

import java.util.List;

public interface IUserService {

    public  void savaUser(UserEntity userEntity);

    public  void delUser(UserEntity userEntity);
    public  void delUser(String id);
    public List<UserEntity> findAll();
    public List<UserEntity> findListByArray(Object[] objects);
}
