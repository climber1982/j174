package com.lovo.spring.entity;

import javax.persistence.*;
import java.util.Set;

@Entity  //被Hibernate管理的标记
@Table(name ="sys_user" ) //映射表
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    @Column(name="u_name",length = 48,nullable = false,unique =true )
    private String userName;
    @Column(length = 48)
    private  String password;

    @OneToMany(mappedBy = "user")
    private Set<RoleUserEntity> roleUserSets;



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Set<RoleUserEntity> getRoleUserSets() {
        return roleUserSets;
    }

    public void setRoleUserSets(Set<RoleUserEntity> roleUserSets) {
        this.roleUserSets = roleUserSets;
    }
}
