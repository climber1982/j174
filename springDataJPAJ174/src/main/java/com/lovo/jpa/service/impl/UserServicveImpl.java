package com.lovo.jpa.service.impl;

import com.lovo.jpa.dao.UserDao;
import com.lovo.jpa.dto.UserDto;
import com.lovo.jpa.entity.UserEntity;
import com.lovo.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
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

    @Transactional(rollbackFor = {Exception.class})
    public void savaList(List<UserEntity> list) {
        userDao.saveAll(list);
    }

    @Override
    public List<UserEntity> getPageList(int age, PageRequest paeable) {
        return userDao.getPageList(age,paeable);
    }

    @Override
    public List<UserEntity> getSQLList(int age) {
        return userDao.getSQLList(age);
    }

    @Override
    public List<UserEntity> getSqlObjectArray(int age) {
     List<Object[]> listObjes=   userDao.getSqlObjectArray(age);
        List<UserEntity> list=null;
      //如果查询结果不为空
     if(!listObjes.isEmpty()&&null!=listObjes){
         list=new ArrayList<>();
         //把结果放入到List<UserEntity>
         for(Object[] objs:listObjes){
             UserEntity userEntity=new UserEntity();
             userEntity.setUserName(objs[0].toString());
             userEntity.setPassword(objs[1].toString());
             list.add(userEntity);
         }
     }
        return list;
    }

    @Transactional(rollbackFor = {Exception.class})
    public int delUserByName(String userName) {
        return userDao.delUserByName(userName);
    }

    @Transactional(rollbackFor = {Exception.class})
    public int updateUserByName(String userName) {
        return userDao.updateUserByName(userName);
    }

    @Override
    public List<UserEntity> findByUserNameOrAge(String userName, int age) {
        return userDao.findByUserNameOrAge(userName,age);
    }
}
