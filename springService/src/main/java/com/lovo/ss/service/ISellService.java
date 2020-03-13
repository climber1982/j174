package com.lovo.ss.service;

import com.lovo.ss.entity.OrderEntity;

public interface ISellService {
    /**
     * 销售
     * @param orderEntity 订单
     * @return 成功为真，失败为假
     */
    public  boolean sell(OrderEntity orderEntity) throws Exception;
}
