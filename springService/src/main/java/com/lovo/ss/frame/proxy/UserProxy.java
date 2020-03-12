package com.lovo.ss.frame.proxy;

/**
 * 代理者
 */
public class UserProxy implements IUser {
    //持有被代理者
    private  IUser user;
    public UserProxy(IUser user){
        this.user=user;
    }
    public void say() {
       //增强功能
        System.out.println("拿着喇叭大喊");
        //调用被代理者的方法
        try {
            user.say();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
