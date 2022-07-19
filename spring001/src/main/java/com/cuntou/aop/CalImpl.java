package com.cuntou.aop;

import org.springframework.stereotype.Component;

@Component
public class CalImpl implements Cal {
    @Override
    public int add(Integer num1, Integer num2) {
        int result = num1+num2;
        return result;
    }

    @Override
    public int sub(Integer num1, Integer num2) {
        int result = num1-num2;
        return result;
    }

    @Override
    public int mul(Integer num1, Integer num2) {
        int result = num1*num2;
        return result;
    }

    @Override
    public int div(Integer num1, Integer num2) {
        int result = num1/num2;
        return result;
    }
}
