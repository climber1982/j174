package com.lovo.spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "teacher")
public class TeacherEntity {

    private  String teacherName;
    private  String teacherClass;

     @Autowired //按照类型来注入-DI
     private  StudentEntity studentEntity;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherClass() {
        return teacherClass;
    }

    public void setTeacherClass(String teacherClass) {
        this.teacherClass = teacherClass;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public  String getStudentInfo(){
        return studentEntity.getStuName()+"/"+studentEntity.getStuAge();
    }
}
