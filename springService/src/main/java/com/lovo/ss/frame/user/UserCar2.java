package com.lovo.ss.frame.user;

import com.lovo.ss.frame.IMessage;

/**
 * 用户操作汽车
 * 用户实现框架的接口，重新框架的方法
 */
public class UserCar2 implements IMessage {
    @Override
    public String getMessage() {
        return "start";
    }
}
