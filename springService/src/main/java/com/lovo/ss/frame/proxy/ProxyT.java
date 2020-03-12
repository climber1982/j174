package com.lovo.ss.frame.proxy;

import java.lang.reflect.Proxy;

public class ProxyT {
    //JDK已经封装好了动态代理
    public static void main(String[] args) {
        //被代理者
        IUser user=new User();
        //给动态代理指令
     user= (IUser) Proxy.newProxyInstance(IUser.class.getClassLoader(),
                new Class[]{IUser.class},
                new MyInvocationHandler(user));
        try {
            user.say();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
