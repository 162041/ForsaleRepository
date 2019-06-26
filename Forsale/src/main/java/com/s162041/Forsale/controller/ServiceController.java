package com.s162041.Forsale.controller;

import com.s162041.Forsale.entity.Services;
import com.s162041.Forsale.service.ServicerService;
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
 * date: 2019-6-15
 * 主要功能说明 ……
 */
@Controller
@RequestMapping("/")
public class ServiceController {
    @Resource
    private ServicerService servicerService;

    /*
    * 获取所有客服
    * */
    @RequestMapping("services")
    public ModelAndView getServiceList(){
        ModelAndView mv = new ModelAndView("services");
        List<Services> list=servicerService.getServiceList();
        mv.addObject("serviceList",list);
        return mv;
    }

    /*
    * 添加客服
    * */
    @RequestMapping("/addService")
    public String addService(Services services){
        servicerService.addService(services);
        return "redirect:/services";
    }
    /*
    * 通过id删除客服
    * */
    @RequestMapping("/deleteServiceById")
    public String deleteServiceById(String id){
        servicerService.deleteServiceById(id);
        return "redirect:/services";
    }

}
