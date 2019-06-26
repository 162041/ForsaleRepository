package com.s162041.Forsale.service;

import com.s162041.Forsale.dao.OrderDao;
import com.s162041.Forsale.entity.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019-6-16
 * 主要功能说明 ……
 */
@Service
public class OrderService implements OrderDao {
    @Resource
    private OrderDao orderDao;
    @Override
    public List<Order> getOrderList() {
        return orderDao.getOrderList();
    }

    @Override
    public int editOrderState() {
        return orderDao.editOrderState();
    }
}
