package com.s162041.Forsale.controller;


import com.s162041.Forsale.dao.LoginAdminRepository;
import com.s162041.Forsale.entity.LoginAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/")
public class LoginAdminController {
    @Resource
    private LoginAdminRepository loginAdminDao;
    private LoginAdmin loginUser;
    @RequestMapping("login")
    public String login(Model model, String Aname, String Apassword) {
        try {
            loginUser = loginAdminDao.getLoginAdmin(Aname,Apassword);
            System.out.println(Aname + Apassword+loginUser.getAID()+loginUser.getAtel());
            if (loginUser != null) {
                model.addAttribute("loginUser", loginUser);
                System.out.println("成功");
                return "index2";
            } else {
                System.out.println("账号密码不匹配");
                return "login";
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("用户名或密码错误!请重新登录");
            return "login";
        }
    }
    //首页
    @GetMapping("index")
    public String index(Model model){
        model.addAttribute("loginUser", loginUser);
        return "index2";
    }

    //个人信息界面
    @GetMapping("personal_information")
    public String personal_information(Model model){
        model.addAttribute("loginUser", loginUser);
        System.out.println(loginUser.getAname());
        return "personal_information";
    }
    @PostMapping("personal_information")
    public String change_personal_information(Model model,String Aname,String Atel){
        loginAdminDao.setLoginAdmin(loginUser.getAID(),Aname,Atel);
        //更新loginUser
        loginUser = loginAdminDao.getLoginAdmin(Aname,loginUser.getApassword());
        model.addAttribute("loginUser", loginUser);
        System.out.println(Aname +"#"+Atel+"#"+loginUser.getAname());
        return "personal_information";
    }
}
