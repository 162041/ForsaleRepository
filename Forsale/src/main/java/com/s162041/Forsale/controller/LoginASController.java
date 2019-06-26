package com.s162041.Forsale.controller;

import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.entity.Services;
import com.s162041.Forsale.service.LoginASService;
import com.s162041.Forsale.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 162041班 第2组
 * 校园二手交易平台——后台登录模块
 *
 * @author: 张侃
 * date: 2019/6/2
 * 主要功能说明 后台登录界面连接数据库跳转
 */
@Controller
@RequestMapping("/")
public class LoginASController {
    @Resource
    private LoginASService loginAdminService;

    /*
    * 管理员登录请求
    * */
    @RequestMapping("Adminlogin")

    public String Adminlogin(String aname, String apassword,HttpSession httpSession ) {
        try {
        Admin admin = loginAdminService.getLoginAdmin(new Admin(aname,apassword));
        System.out.println(aname+apassword);
        if(admin!=null){
            httpSession.setAttribute("admin", admin);
            System.out.println("成功");
            return "AdminMain";
        }
        else {
            System.out.println("账号密码不匹配");
            return "admin_service_login";
        }
    } catch (Exception e) {
        System.out.println(e);
        System.out.println("用户名或密码错误!请重新登录");
        return "admin_service_login";
    }

}
    /*
    * 客服登录请求
    * */
    @RequestMapping("ServiceLogin")
    public String ServiceLogin(String kname, String kpassword,HttpSession httpSession) {
        try {
            Services services = loginAdminService.getLoginService(new Services(kname,kpassword));
            System.out.println(kname+kpassword);
            if(services!=null){
            	httpSession.setAttribute("services", services);
                System.out.println("成功");
                return "ServiceMain";
            }
            else {
                System.out.println("账号密码不匹配");
                return "admin_service_login";
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println("用户名或密码错误!请重新登录");
            return "admin_service_login";
        }

    }
}
