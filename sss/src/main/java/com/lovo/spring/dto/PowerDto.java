package com.lovo.spring.dto;

import javax.persistence.Column;

public class PowerDto {

    private  String powerName;
    private String powerUri;
    private  String userName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
