package com.lovo.spring.config;

import com.lovo.spring.entity.StudentEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {
    @Bean
    public StudentEntity studentEntity(){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setStuName("白文楷");
        studentEntity.setStuAge(18);
        return  studentEntity;
    }
}
