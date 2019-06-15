package com.s162041.Forsale.controller;

import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.service.LoginASService;
import com.s162041.Forsale.util.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("login")
    public String login(String aname, String apassword) {
        try {
        Admin admin = loginAdminService.getLoginAdmin(new Admin(aname,apassword));
        System.out.println(aname+apassword);
        if(admin!=null){

            System.out.println("成功");
            return "main";
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
    @GetMapping(value = "code")
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ImageUtil imageUtil = new ImageUtil(120, 35, 5,30);
        session.setAttribute("code", imageUtil.getCode());
        imageUtil.write(response.getOutputStream());
        return null;
    }


    /*@RequestMapping("create")
    public String createAccount(String username,String password,String tel,HttpServletRequest request){
        String code = ""+request.getSession().getAttribute("code");

        return "index";
    }*/
}
