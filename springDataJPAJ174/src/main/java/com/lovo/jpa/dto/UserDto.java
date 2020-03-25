package com.lovo.jpa.dto;

public class UserDto {

    private  String userName;
    private  int userAge;
    public UserDto(){}
    public UserDto(String userName, int userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
