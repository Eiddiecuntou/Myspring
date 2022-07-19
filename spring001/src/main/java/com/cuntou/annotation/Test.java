package com.cuntou.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        //加载Spring容器
        ApplicationContext ioc = new AnnotationConfigApplicationContext("com.southwind.entity");
        Object user = ioc.getBean("abc");
        System.out.println(user);

//        ApplicationContext ioc = new AnnotationConfigApplicationContext(UserConfiguration.class);
//        System.out.println(ioc.getBean("user"));
    }
}
