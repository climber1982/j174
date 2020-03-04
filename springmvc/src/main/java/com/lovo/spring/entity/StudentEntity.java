package com.lovo.spring.entity;

import org.springframework.stereotype.Component;


public class StudentEntity {

    private  String stuName;
    private  int stuAge;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
}
