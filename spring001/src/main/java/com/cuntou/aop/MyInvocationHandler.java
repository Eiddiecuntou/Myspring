package com.cuntou.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyInvocationHandler implements InvocationHandler {
    //委托对象
    private Object object = null;

    //返回代理对象
    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(
                MyInvocationHandler.class.getClassLoader(),
                object.getClass().getInterfaces(),
                this
                );
    }

    //调用代理对象执行方法的时候，就会进入invoke方法
    //操作委托对象，执行业务代码
    //操作代理对象，执行日志打印
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" method args are:" + Arrays.toString(args));
        Object result = method.invoke(this.object, args);
        System.out.println(method.getName()+" method result:" + result);
        return result;
    }
}
