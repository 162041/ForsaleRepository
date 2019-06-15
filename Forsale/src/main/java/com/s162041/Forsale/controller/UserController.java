package com.s162041.Forsale.controller;

import com.s162041.Forsale.entity.Buyer;
import com.s162041.Forsale.entity.Seller;
import com.s162041.Forsale.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/buyer")
    public ModelAndView getUserList(){
        ModelAndView mv = new ModelAndView("buyer");
        List<Buyer> list=userService.getBuyerList();
        mv.addObject("buyerList",list);
        return mv;
    }

    @RequestMapping("/seller")
    public ModelAndView getSellerList(){
        ModelAndView mv = new ModelAndView("seller");
        List<Seller> list=userService.getSellerList();
        mv.addObject("sellerList",list);
        return mv;
    }

    /*@RequestMapping("/service")
    public ModelAndView getBuyerList(){
        ModelAndView mv = new ModelAndView("service");
        List<Seller> list=userService.getSellerList();
        mv.addObject("userList",list);
        return mv;
    }*/

    /*@RequestMapping("/admin")
    public ModelAndView getAdminList(){
        ModelAndView mv = new ModelAndView("admin");
        List<User> list=userDao.getUserList();
        mv.addObject("userList",list);
        return mv;
    }*/
}
