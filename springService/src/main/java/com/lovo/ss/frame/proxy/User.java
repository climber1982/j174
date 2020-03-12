package com.lovo.ss.frame.proxy;

public class User implements IUser {

    public void say() throws InterruptedException {
        Thread.sleep(100*5);
        System.out.println("今天来的人真少");
    }
}
