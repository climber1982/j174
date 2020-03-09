package com.lovo.spring.controller;

import com.lovo.spring.entity.StudentEntity;
import com.lovo.spring.entity.TeacherEntity;
import com.lovo.spring.vo.UserVO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

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
  @RequestMapping("getListUser.lovo")
   public String getListUser()  {
        //调用服务器数据，所以它对于浏览器属于后端，对于后端服务器属于客户端
      //1、创建httpclient 对象
      HttpClient httpClient= HttpClients.createDefault();
      //创建get对象
      HttpGet httpGet=new HttpGet("http://localhost:8081/ss/getUserList2.lovo");
      //执行get请求,并获取返回
      try {
          HttpResponse httpResponse= httpClient.execute(httpGet);
          //获取返回的实体
          HttpEntity httpEntity= httpResponse.getEntity();
          //获取实体对象中的字符，也就是后端返回的json
       String json=   EntityUtils.toString(httpEntity,"utf-8");

          return json;
      } catch (IOException e) {
          e.printStackTrace();
      }
   return  "";
   }

}
