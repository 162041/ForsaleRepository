package com.s162041.Forsale.controller;


import com.s162041.Forsale.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.s162041.Forsale.entity.Orders;
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

    @RequestMapping("order")
    public ModelAndView getOrderList(){
        ModelAndView mv =new ModelAndView("order_admin");
        List<Orders> list = orderService.getOrderList();
        mv.addObject("orderList",list);
        return mv;
    }
}
