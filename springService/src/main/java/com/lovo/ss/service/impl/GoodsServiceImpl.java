package com.lovo.ss.service.impl;

import com.lovo.ss.dao.IGoodsDao;
import com.lovo.ss.entity.OrderEntity;
import com.lovo.ss.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "goodsService")
public class GoodsServiceImpl implements IGoodsService {
   @Autowired
    private IGoodsDao goodsDao;

    public boolean updateGoods(OrderEntity orderEntity) {
       boolean bl=false;
        int i= goodsDao.updateGoods(orderEntity);
        if(i>0){
            bl=true;
        }
        return bl;
    }
}
