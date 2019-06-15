package com.s162041.Forsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 162041班 第2组
 * 校园二手交易平台
 *
 * @author: 张侃
 * date: 2019/6/5
 * 主要功能说明：控制初始开启界面
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model){
        return "admin_service_login";
    }
}
