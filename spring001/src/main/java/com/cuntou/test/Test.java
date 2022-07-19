package com.cuntou.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        User user = new User();
//        user.setId(1);
//        user.setName("张三");
//        user.setAge(22);
//        System.out.println(user);
        //加载Spring
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Object user = applicationContext.getBean("user");
        System.out.println(user);
    }
}
