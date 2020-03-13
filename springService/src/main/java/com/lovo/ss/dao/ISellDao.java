package com.lovo.ss.dao;

import com.lovo.ss.entity.OrderEntity;

public interface ISellDao {
    /**
     * 销售
     * @param orderEntity  订单
     */
    public  int sell(OrderEntity orderEntity);
}
