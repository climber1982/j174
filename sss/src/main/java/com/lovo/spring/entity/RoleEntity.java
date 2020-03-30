package com.lovo.spring.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int roleId;
    private  String roleName;

    @OneToMany(mappedBy = "role")
    private Set<RoleUserEntity> roleUserSets;

    public Set<RoleUserEntity> getRoleUserSets() {
        return roleUserSets;
    }

    public void setRoleUserSets(Set<RoleUserEntity> roleUserSets) {
        this.roleUserSets = roleUserSets;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
