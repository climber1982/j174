package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IUserDao;
import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    public List<UserEntity> getListUser() {
        return userDao.getListUser();
    }

    @Override
    public UserEntity getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }


    public void upadteUser(UserEntity userEntity) {
        userDao.addUser(userEntity);
        userDao.updateUser(userEntity);
    }
}
