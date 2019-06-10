package com.zh.springbootmultidatasource.service.impl;

import com.zh.springbootmultidatasource.service.BookProductService;
import com.zh.springbootmultidatasource.service.OrderService;
import com.zh.springbootmultidatasource.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanghang
 * @date 2019/6/6
 */
@Service
public class BookProductServiceImpl implements BookProductService {

    @Autowired
    private StockService stockService;

    @Autowired
    private OrderService orderService;


    @Override
    public void bookProduct(Integer productId, Integer userId) {
        //订单表插入一条数据
        this.orderService.save(productId,userId);
        //库存表扣减一份商品
        this.stockService.decrementByProductId(productId);
    }
}
