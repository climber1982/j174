package com.lovo.ss.frame.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
   //交给框架被代理者
    private  Object obj;
   public MyInvocationHandler(Object obj){
       this.obj=obj;
   }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //增强功能
      long s= System.currentTimeMillis();
        //调用目标方法

      Object objinfo=  method.invoke(obj,args);
        System.out.println(proxy.getClass().getSimpleName());
        long e= System.currentTimeMillis();
        System.out.println("调用"+method.getName()+"所用的时间:"+(e-s));
        return objinfo;
    }
}
