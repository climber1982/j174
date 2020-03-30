package com.lovo.spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_power")
public class PowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int powerId;
    @Column(name = "p_name",length = 80)
    private  String powerName;
    @Column(name = "p_uri")
    private String powerUri;

    public int getPowerId() {
        return powerId;
    }

    public void setPowerId(int powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerUri() {
        return powerUri;
    }

    public void setPowerUri(String powerUri) {
        this.powerUri = powerUri;
    }
}
