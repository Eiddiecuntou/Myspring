package com.cuntou.xml;

import com.cuntou.xml.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
//        ApplicationContext ioc = new AnnotationConfigApplicationContext("com.southwind.xml");
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-aop.xml");
        UserController userController = (UserController) ioc.getBean("userController");
        System.out.println(userController.getById(1));
    }
}
