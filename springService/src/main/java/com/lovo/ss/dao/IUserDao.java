package com.lovo.ss.dao;

import com.lovo.ss.entity.UserEntity;

import java.util.List;

public interface IUserDao {
    /**
     * 获得所有的用户
     * @return
     */
    public List<UserEntity> getListUser();

    /**
     * 根据用户名返回对象
     * @param userName
     * @return
     */
    public UserEntity getUserByName(String userName);

    public  void addUser(UserEntity user);

    public  void updateUser(UserEntity user);
}
