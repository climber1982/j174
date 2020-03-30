package com.lovo.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_power")
public class RolePowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int rolePowerId;
    @ManyToOne
    @JoinColumn(name = "p_id")
    private  PowerEntity power;
    @ManyToOne
    @JoinColumn(name = "r_id")
    private  RoleEntity role;

    public int getRolePowerId() {
        return rolePowerId;
    }

    public void setRolePowerId(int rolePowerId) {
        this.rolePowerId = rolePowerId;
    }

    public PowerEntity getPower() {
        return power;
    }

    public void setPower(PowerEntity power) {
        this.power = power;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
