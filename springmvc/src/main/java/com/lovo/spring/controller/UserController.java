package com.lovo.spring.controller;

import com.lovo.spring.entity.StudentEntity;
import com.lovo.spring.entity.TeacherEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//整个类的方法不会再做视图渲染，只返回数据
@RestController
public class UserController {

    @RequestMapping("getStudent.lovo")
    //@ResponseBody //不做视图渲染，只返回数据
    public StudentEntity getStudent(){

        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setStuName("赵云");
        studentEntity.setStuAge(30);
        return studentEntity;
    }
    @RequestMapping("getTeacher.lovo")
    public TeacherEntity getTeacher(){

       TeacherEntity t=new TeacherEntity();
       t.setTeacherClass("ss");
       t.setTeacherName("dd");
        return t;
    }
}
