package com.lovo.ss.frame;

/**
 * 模拟一个框架
 * 接受用户指令，如果收到start,输出发动汽车，如果收到stop,停止汽车
 */
public interface IMyFrame {
    /**
     * 操控汽车
     * @param message  操控汽车的指令
     */
     public  void contrllorCar(IMessage message);
}
