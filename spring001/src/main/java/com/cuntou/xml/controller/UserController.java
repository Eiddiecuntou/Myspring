package com.cuntou.xml.controller;

import com.cuntou.entity.User;
import com.cuntou.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class UserController {

    @Autowired
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    public User getById(Integer id){
        return this.userService.getById(id);
    }

}
