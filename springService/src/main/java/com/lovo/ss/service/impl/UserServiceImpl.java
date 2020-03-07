package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IUserDao;
import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    public List<UserEntity> getListUser() {
        return userDao.getListUser();
    }
}
