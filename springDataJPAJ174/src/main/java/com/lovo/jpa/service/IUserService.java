package com.lovo.jpa.service;

import com.lovo.jpa.entity.UserEntity;

import java.util.List;

public interface IUserService {

    public List<UserEntity> getListUserByAge(int age);
}
