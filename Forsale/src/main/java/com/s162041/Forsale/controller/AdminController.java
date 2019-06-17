package com.s162041.Forsale.controller;

import com.s162041.Forsale.dao.AdminDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class AdminController {

    @RequestMapping("editAdmin")
    public String editAdmin(){
        return "editadmin";
    }

}
