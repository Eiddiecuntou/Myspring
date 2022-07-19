package com.cuntou.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        //委托对象
//        Cal cal = new CalImpl();
//        //handler
//        MyInvocationHandler handler = new MyInvocationHandler();
//        Cal proxy = (Cal) handler.bind(cal);
//        System.out.println(proxy.add(1, 1));
//        System.out.println(proxy.sub(2, 1));
//        System.out.println(proxy.mul(3, 6));
//        System.out.println(proxy.div(9, 3));
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-aop.xml");
        //代理对象
        Cal bean = ioc.getBean(Cal.class);
        System.out.println(bean.add(1, 1));
    }
}
