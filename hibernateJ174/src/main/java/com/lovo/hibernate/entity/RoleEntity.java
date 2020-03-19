package com.lovo.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_role")
public class RoleEntity {
    @Id
    //设置表中列的属性
    @Column(length = 32)
    //自定义UUID
    @GenericGenerator(name = "roleuuid",strategy = "uuid")
    //给id一个生产策略,自定义生成策略
    @GeneratedValue(generator = "roleuuid")
    private  String roleId;
    private  String roleName;

    @OneToMany(mappedBy = "role")
    private Set<RoleUserEntity> roleUserSets;

    public Set<RoleUserEntity> getRoleUserSets() {
        return roleUserSets;
    }

    public void setRoleUserSets(Set<RoleUserEntity> roleUserSets) {
        this.roleUserSets = roleUserSets;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
