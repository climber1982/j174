package com.lovo.ss.frame.proxy;

public class T {
    public static void main(String[] args) {
        //被代理
        IUser user=new User();
        //代理者
        UserProxy proxy=new UserProxy(user);
        //调用代理的方法
        proxy.say();
    }
}
