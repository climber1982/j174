package com.lovo.ss.service;

import com.lovo.ss.entity.UserEntity;

import java.util.List;

public interface IUserService {
    /**
     * 获得所有的用户
     * @return
     */
    public List<UserEntity> getListUser();

    /**
     * 根据用户查询用户对象
     * @param userName
     * @return
     */
    public UserEntity getUserByName(String userName);

    public void upadteUser(UserEntity userEntity);
}
