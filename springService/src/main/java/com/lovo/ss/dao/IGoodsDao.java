package com.lovo.ss.dao;

import com.lovo.ss.entity.OrderEntity;

public interface IGoodsDao {
    /**
     * 修改商品
     * @param orderEntity  订单
     */
    public int updateGoods(OrderEntity orderEntity);
}
