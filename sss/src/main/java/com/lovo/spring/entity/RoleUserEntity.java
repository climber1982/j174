package com.lovo.spring.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="sys_role_user")
public class RoleUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int roleUserId;
    @ManyToOne
    @JoinColumn(name = "f_u_id")
    private UserEntity  user;
    @ManyToOne
    @JoinColumn(name = "f_r_id")
    private  RoleEntity role;

    public int getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(int roleUserId) {
        this.roleUserId = roleUserId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
