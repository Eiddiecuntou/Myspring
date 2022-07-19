package com.cuntou.xml;

import com.cuntou.entity.User;
import com.cuntou.xml.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserController userController = (UserController) ioc.getBean("userController");
        User byId = userController.getById(2);
        System.out.println(byId);
    }
}
