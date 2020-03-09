package com.lovo.ss.controller;

import com.lovo.ss.entity.UserEntity;
import com.lovo.ss.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("getUserList2.lovo")
    public List<UserEntity> getUserList(){
       return  userService.getListUser();
    }

}
