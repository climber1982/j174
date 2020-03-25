package com.lovo.jpa.service.impl;

import com.lovo.jpa.dao.UserDao;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userService")
public class UserServicveImpl implements IUserService {
    @Autowired
    UserDao userDao;

    public List<UserEntity> getListUserByAge(int age) {
        return userDao.getListUserByAge(age);
    }
}
