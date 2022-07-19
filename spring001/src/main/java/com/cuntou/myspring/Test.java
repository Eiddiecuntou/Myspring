package com.cuntou.myspring;

public class Test {
    public static void main(String[] args) {
        MyApplicationContext ioc = new MyApplicationContext("spring.xml");
        Object user = ioc.getBean("user1");
        System.out.println(user);
    }
}
