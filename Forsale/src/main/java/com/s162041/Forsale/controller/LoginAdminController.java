package com.s162041.Forsale.controller;

import com.s162041.Forsale.dao.LoginAdminDao;
import com.s162041.Forsale.entity.LoginAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019/6/2
 * 主要功能说明 ……
 */
@Controller
@RequestMapping("/")
public class LoginAdminController {
    @Resource
    private LoginAdminDao loginAdminDao;
    @RequestMapping("login")
    public String login(String Aname, String Apassword) {
        try {
        LoginAdmin loginUser = loginAdminDao.getLoginAdmin(new LoginAdmin(Aname,Apassword));
        System.out.println(Aname+Apassword);
        if(loginUser!=null){

            System.out.println("成功");
            return "index1";
        }
        else {
            System.out.println("账号密码不匹配");
            return "index";
        }
    } catch (Exception e) {
        System.out.println(e);
        System.out.println("用户名或密码错误!请重新登录");
        return "index";
    }

}
}
