package com.lovo.sh.dao;

import com.lovo.sh.entity.RoleEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository(value = "roleDao")
public class RoleDao extends BasicDao<RoleEntity> {
}
