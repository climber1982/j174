package com.goods;

import com.lovo.ss.entity.OrderEntity;
import com.lovo.ss.service.IGoodsService;
import com.lovo.ss.service.ISellService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    ISellService sellService;
    IGoodsService  goodsService;
    @Before
    public  void before(){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("application.xml");
        sellService = (ISellService) context.getBean("sellService");
         goodsService= (IGoodsService) context.getBean("goodsService");
    }
    @Test
    public  void tsell(){
         //模拟一个订单
        OrderEntity order=new OrderEntity();
        order.setGoodsName("JAVA编程思想2");
        //商品编号
        order.setGoodsNum("J_20200313_004");
        order.setSellPrice(50);
        //执行
        boolean bl= false;
        try {
            bl = sellService.sell(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bl);

    }
   @Test
    public  void tgoods(){
       OrderEntity order=new OrderEntity();
       order.setGoodsName("JAVA书");
       //商品编号
       order.setGoodsNum("J_20200313_001");
       order.setSellPrice(50);
       goodsService.updateGoods(order);
    }

}
