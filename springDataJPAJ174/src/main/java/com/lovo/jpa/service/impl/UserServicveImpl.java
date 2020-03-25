package com.lovo.jpa.service.impl;

import com.lovo.jpa.dao.UserDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service(value = "userService")
public class UserServicveImpl implements IUserService {
    @Autowired
    UserDao userDao;

    public List<UserEntity> getListUserByAge(int age) {
        return userDao.getListUserByAge(age);
    }

    public List<UserEntity> getListUserByAgeParam(int age) {
        return userDao.getListUserByAgeParam(age);
    }

    public List<UserDto> getListDTO() {
        return userDao.getListDTO();
    }

    public List<Map> getListMap() {
        return userDao.getListMap();
    }
    @Transactional(rollbackFor = {Exception.class})
    public UserEntity savaUser(UserEntity user) {
        return userDao.save(user);
    }

    public List<UserEntity> findList() {
        return (List<UserEntity>) userDao.findAll();
    }

    public UserEntity getUserById(String id) {
        Optional<UserEntity> optional= userDao.findById(id);

        return optional.get();
    }

    public void delUserById(String id) {
        userDao.deleteById(id);
    }
}
