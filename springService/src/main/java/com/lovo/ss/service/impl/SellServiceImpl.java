package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IGoodsDao;
import com.lovo.ss.dao.ISellDao;
import com.lovo.ss.entity.OrderEntity;
import com.lovo.ss.service.IGoodsService;
import com.lovo.ss.service.ISellService;
import com.lovo.ss.util.SellExcetion;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "sellService")
public class SellServiceImpl implements ISellService {
    @Autowired
    private ISellDao sellDao;

    @Autowired
    private IGoodsDao goodsDao;

    @Autowired
    private IGoodsService goodsService;

    public boolean sell(OrderEntity orderEntity) throws SellExcetion {
     boolean bl=false;
      int i=  sellDao.sell(orderEntity);
        //修改库存
     int j=   goodsDao.updateGoods(orderEntity);
        if(j==0){
            throw  new SellExcetion("销售失败！！");
        }
        return bl;
    }
   //T
    public boolean sell2(OrderEntity orderEntity) throws SellExcetion {
        boolean bl=false;
        int i=  sellDao.sell(orderEntity);
        //修改库存
      boolean blg=  goodsService.updateGoods(orderEntity);
        return bl;
    }
}
