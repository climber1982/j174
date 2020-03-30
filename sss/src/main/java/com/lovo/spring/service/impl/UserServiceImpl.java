package com.lovo.spring.service.impl;

import com.lovo.spring.dao.IUserDao;
import com.lovo.spring.dto.PowerDto;
import com.lovo.spring.entity.UserEntity;
import com.lovo.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserEntity findByUserNameAndPassword(String userName, String password) {
        return userDao.findByUserNameAndPassword(userName, password);
    }

    @Override
    public List<PowerDto> findPowerListByName(String userName) {
        List<PowerDto> listDto=null;
     List<Object[]> listObjs=   userDao.findPowerByUserName(userName);
      //如果listObjs 不为空就获取数据放入到List<PowerDto>
        if(null!=listObjs&&!listObjs.isEmpty()){
            listDto=new ArrayList<>();
            //组装
            for(Object[] objs:listObjs){
                PowerDto powerDto=new PowerDto();
                powerDto.setUserName(objs[0].toString());
                powerDto.setPowerName(objs[1].toString());
                powerDto.setPowerUri(objs[2].toString());
                listDto.add(powerDto);
            }
        }
        return listDto;
    }
}
