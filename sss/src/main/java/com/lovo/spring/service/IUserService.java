package com.lovo.spring.service;

import com.lovo.spring.dto.PowerDto;
import com.lovo.spring.entity.UserEntity;

import java.util.List;

public interface IUserService
{
    //登录
    public UserEntity findByUserNameAndPassword(String userName, String password);

    /**
     * 根据用户查询出权限集合
     * @param userName
     * @return
     */
    public List<PowerDto> findPowerListByName(String userName);

}
