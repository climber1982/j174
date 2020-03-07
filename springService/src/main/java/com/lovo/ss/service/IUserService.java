package com.lovo.ss.service;

import com.lovo.ss.entity.UserEntity;

import java.util.List;

public interface IUserService {
    /**
     * 获得所有的用户
     * @return
     */
    public List<UserEntity> getListUser();
}
