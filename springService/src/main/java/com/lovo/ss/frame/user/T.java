package com.lovo.ss.frame.user;

import com.lovo.ss.frame.IMessage;
import com.lovo.ss.frame.IMyFrame;
import com.lovo.ss.frame.MyFrame;

public class T {
    public static void main(String[] args) {
        //创建指令
        IMessage message=new UserCar2();
        //运行框架
        //创建框架对象
        IMyFrame frame=new MyFrame();
        //调用框架,放入用户指令
        frame.contrllorCar(message);

    }
}
