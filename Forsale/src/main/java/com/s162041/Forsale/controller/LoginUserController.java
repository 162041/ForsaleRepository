package com.s162041.Forsale.controller;


import com.s162041.Forsale.dao.GoodsRepository;
import com.s162041.Forsale.dao.LoginUserRepository;
import com.s162041.Forsale.entity.Goods;
import com.s162041.Forsale.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.List;


@Controller
public class LoginUserController {
    @Autowired
    private LoginUserRepository loginUserDao;
    @Autowired
    private GoodsRepository goodsDao;
    private List<Goods> goodsList;
    private LoginUser loginUser;
    private Goods goods;
    //登陆界面
    @GetMapping("/")
    public String login(Model model){
        return "login";
    }
    @PostMapping("login")
    public String login(Model model, String Bname, String Bpassword) {
        try {
            loginUser = loginUserDao.getLoginUser(Bname,Bpassword);
            System.out.println(Bname + Bpassword+loginUser.getBID()+loginUser.getBtel());
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
        System.out.println("index:"+loginUser.getBname());
        model.addAttribute("loginUser", loginUser);
        return "index2";
    }

    //个人信息界面
    @GetMapping("personal_information")
    public String personal_information(Model model){
        model.addAttribute("loginUser", loginUser);
        System.out.println(loginUser.getBname());
        return "personal_information";
    }
    @PostMapping("personal_information")
    public String change_personal_information(Model model,String Bname,String Atel){
        loginUserDao.setLoginUser(loginUser.getBID(),Bname,Atel);
        //更新loginUser
        loginUser = loginUserDao.getLoginUser(Bname,loginUser.getBpassword( ));
        model.addAttribute("loginUser", loginUser);
        System.out.println(Bname +"#"+Atel+"#"+loginUser.getBname());
        return "personal_information";
    }

    //发布商品界面
    @GetMapping("release_goods")
    public String release_goods(Model model){
        model.addAttribute("loginUser", loginUser);
        System.out.println(loginUser.getBname());
        return "release_goods";
    }
    @PostMapping("release_goods")
    public String release_goods_submit(Model model, String Gname, String Gdescribe, String Gprices, String Gtype, MultipartFile filename)throws Exception{
        System.out.println("#"+Gname+"#"+Gprices+"#"+Gtype+"#"+Gdescribe+"#"+filename.getOriginalFilename()+"#"+loginUser.getBID());
        String str="images/"+filename.getOriginalFilename();
        filename.transferTo(new File("D:/GitHub/ForsaleRepository/Forsale/src/main/resources/static/"+str));
        model.addAttribute("loginUser", loginUser);
        goodsDao.addGoodsRepository(Gname,Gprices,Gtype,Gdescribe,str,"00001");
        return "index2";
    }
    //分页商品
    @GetMapping("category_pages")
    public String category_pages (Model model,String Gtype){
        System.out.println(Gtype);
        model.addAttribute("loginUser", loginUser);
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("goodsList",goodsList);
        return "category_pages";
    }
    //进入详细订单页面
    @GetMapping("goods_details")
    public String goods_details (Model model,String GID){
        System.out.println(GID);
        goods=goodsDao.findByGID(GID);
//        java.util.Date date=new java.util.Date(goods.getGdate().getTime());
//        System.out.println(date);
        System.out.println(goods.getGname());
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", loginUser);
        return "goods_details";
    }
}
