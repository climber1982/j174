package com.lovo.sh.service.impl;

import com.lovo.sh.dao.BasicDao;
import com.lovo.sh.dao.UserDao;
import com.lovo.sh.entity.UserEntity;
import com.lovo.sh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "userService")
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements IUserService {
    @Autowired
    UserDao userDao;

    public void savaUser(UserEntity userEntity) {
        userDao.savaObject(userEntity);
    }
}
