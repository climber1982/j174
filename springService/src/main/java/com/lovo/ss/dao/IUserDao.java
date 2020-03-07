package com.lovo.ss.dao;

import com.lovo.ss.entity.UserEntity;

import java.util.List;

public interface IUserDao {
    /**
     * 获得所有的用户
     * @return
     */
    public List<UserEntity> getListUser();
}
