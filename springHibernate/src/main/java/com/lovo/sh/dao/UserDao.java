package com.lovo.sh.dao;

import com.lovo.sh.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDao extends BasicDao<UserEntity> {

}
