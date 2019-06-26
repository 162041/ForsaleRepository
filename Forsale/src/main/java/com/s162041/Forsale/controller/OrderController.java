package com.s162041.Forsale.controller;


import com.s162041.Forsale.entity.Order;
import com.s162041.Forsale.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
@RequestMapping("/")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("orders")
    public ModelAndView getOrderAdminList(){
        ModelAndView mv =new ModelAndView("order_admin");
        List<Order> list = orderService.getOrderList();
        mv.addObject("orderList",list);
        return mv;
    }
    @RequestMapping("orders_service")
    public ModelAndView getOrderServiceList() {
    	ModelAndView mv2=new ModelAndView("order_service");
    	List<Order> list2=orderService.getOrderList();
    	mv2.addObject("orderlist2",list2);
    	return mv2;
    }
}
