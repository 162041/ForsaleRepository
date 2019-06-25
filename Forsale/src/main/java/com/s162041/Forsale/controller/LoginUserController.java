package com.s162041.Forsale.controller;


import com.s162041.Forsale.dao.*;
import com.s162041.Forsale.entity.Address;
import com.s162041.Forsale.entity.Buyer;
import com.s162041.Forsale.entity.Complain;
import com.s162041.Forsale.entity.Goods;
import com.s162041.Forsale.entity.Seller;
import com.s162041.Forsale.entity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;


@Controller
public class LoginUserController {
    @Autowired
    private BuyerRepository loginUserDao;
    @Autowired
    private SellerRepository sellerDao;
    @Autowired
    private GoodsRepository goodsDao;
    @Autowired
    private OrdersRepository ordersDao;
    @Autowired
    private AnnouncementRepository announcementDao;
    @Autowired
    private ComplainRepository complainDao;
    @Autowired
    private AddressRepository addressDao;
    @Autowired
    private ServicesRepository ServiceDao;
    
    private Services Service;
    private Address address;
    private Complain complain;
    private List<Goods> goodsList;
    private Buyer buyer;
    private Seller seller;
    private Goods goods;
    //---------游客----------
    //游客访问
    @GetMapping("/")
    public String visitor(Model model,String Gtype){
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("AnnouncementList",announcementDao.findAll());
        model.addAttribute("goodsList",goodsList);
        return "index1";
    }
    //分页商品
    @GetMapping("visitor_category_pages")
    public String visitor_category_pages (Model model,String Gtype){
        System.out.println(Gtype);
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("goodsList",goodsList);
        return "visitor_category_pages";
    }
    //商品详情
    @GetMapping("visitor_goods_details")
    public String visitor_goods_details (Model model,String GID){
        System.out.println(GID);
        goods=goodsDao.findByGID(GID);
        model.addAttribute("goods",goods);
        return "visitor_goods_details";
    }
    //搜索框模糊查询
    @PostMapping("visitor_search")
    public String visitor_search(Model model,String Gname){
        model.addAttribute("goodsList",goodsDao.findByName(Gname));
        return "visitor_category_pages";
    }
    //---------游客----------
    //--------有身份登陆-----
    //注册
    @PostMapping("register")
    public String register(Model model,String Bname,String Bpassword,String Btel,String pstate){
        String ID=String.valueOf((int)(Math.random()*9999999));//生成ID
        loginUserDao.addLoginUser(ID,Bname,Bpassword,Btel);
        buyer = loginUserDao.getLoginUser(Bname,Bpassword);
        addressDao.addAddress(buyer.getBid(), pstate);
        sellerDao.addSeller(ID,Bname,Bpassword,Btel);
        model.addAttribute("loginUser", buyer);
        return "index2";
    }
    //登陆界面
    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("msg","1");
        return "login";
    }
    @PostMapping("login")
    public String login(Model model, String Bname, String Bpassword) {
        try {
            buyer = loginUserDao.getLoginUser(Bname,Bpassword);
            System.out.println(Bname + Bpassword+ buyer.getBid()+ buyer.getBtel());
            if (buyer != null) {
                model.addAttribute("loginUser", buyer);
                model.addAttribute("AnnouncementList",announcementDao.findAll());
                System.out.println("成功");
                return "index2";
            } else {
                System.out.println("账号密码不匹配");
                return "login";
            }
        } catch (Exception e) {
            System.out.println("用户名或密码错误!请重新登录");
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
    //首页
    @GetMapping("index")
    public String index(Model model){
        System.out.println("Ncontent:"+(announcementDao.findAll().get(0).getNcontent()));
        model.addAttribute("loginUser", buyer);
        model.addAttribute("AnnouncementList",announcementDao.findAll());
        return "index2";
    }
    //搜索框模糊查询
    @PostMapping("search")
    public String search(Model model,String Gname){
        System.out.println("index:"+ buyer.getBname());
        model.addAttribute("goodsList",goodsDao.findByName(Gname));
        model.addAttribute("loginUser", buyer);
        return "category_pages";
    }
    //个人信息界面
    @GetMapping("personal_information")
    public String personal_information(Model model){
        model.addAttribute("loginUser", buyer);
        address=addressDao.getAddress(buyer.getBid());
        model.addAttribute("address",address);
        System.out.println("address:"+address);
        return "personal_information";
    }
    //修改个人信息
    @PostMapping("personal_information")
    public String change_personal_information(Model model,String Bname,String Atel,String Pstate){
        loginUserDao.setLoginUser(buyer.getBid(),Bname,Atel,Pstate);
        address=addressDao.getAddress(buyer.getBid());
        //更新loginUser
        buyer = loginUserDao.getLoginUser(Bname, buyer.getBpassword( ));
        model.addAttribute("loginUser", buyer);
        //更新地址
        addressDao.setAddress(buyer.getBid(), Pstate);
        model.addAttribute(address);
        System.out.println("Pstate"+Pstate);
        return "personal_information";
    }
    //--------商品----------
    //发布商品界面
    @GetMapping("release_goods")
    public String release_goods(Model model){
        model.addAttribute("loginUser", buyer);
        System.out.println(buyer.getBname());
        return "release_goods";
    }
    //发布商品操作
    @PostMapping("release_goods")
    public String release_goods_submit(Model model, String Gname, String Gdescribe, String Gprices, String Gtype, MultipartFile filename)throws Exception{
        System.out.println("#"+Gname+"#"+Gprices+"#"+Gtype+"#"+Gdescribe+"#"+filename.getOriginalFilename()+"#"+ buyer.getBid());
        String str="images/"+filename.getOriginalFilename();
        filename.transferTo(new File("E:/GitHub/ForsaleRepository/Forsale/src/main/resources/static/"+str));
        model.addAttribute("loginUser", buyer);
        goodsDao.addGoodsRepository(Gname,Gprices,Gtype,Gdescribe,str, buyer.getBid());
        return "index2";
    }
    //删除商品
    @GetMapping("delete_goods")
    public String delete_goods_submit(Model model,String GID){
        model.addAttribute("loginUser", buyer);
        goodsDao.deleteGoodsRepository(GID);
        model.addAttribute("goodsList",goodsDao.findAllByBID(buyer.getBid()));
        return "released";
    }
    //分页商品
    @GetMapping("category_pages")
    public String category_pages (Model model,String Gtype){
        System.out.println(Gtype);
        model.addAttribute("loginUser", buyer);
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("goodsList",goodsList);
        return "category_pages";
    }
    //买家查看已购买商品
    @GetMapping("purchase_orders")
    public String purchase_orders (Model model){
        ordersDao.findOrdersByBID(buyer.getBid());
        model.addAttribute("loginUser", buyer);
        model.addAttribute("ordersList",ordersDao.findOrdersByBID(buyer.getBid()));
        return "purchase_orders";
    }
    //卖家查看已发布的商品
    @GetMapping("released")
    public String released(Model model){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("goodsList",goodsDao.findAllByBID(buyer.getBid()));
        return "released";
    }
   //卖家查看已售出的商品
    @GetMapping("sold")
    public String sold(Model model){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("ordersList",ordersDao.findOrdersByOstateAndBID("已出售",buyer.getBid()));
        return "sold";
    }
    //--------订单----------
    //进入详细订单页面
    @GetMapping("goods_details")
    public String goods_details (Model model,String GID){
        System.out.println(GID);
        goods=goodsDao.findByGID(GID);
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", buyer);
        return "goods_details";
    }
    //产生订单操作
    @PostMapping("goods_details")
    public String orders (Model model){
        System.out.println("Gname为"+goods.getGname());
        //订单状态-商品编号-商品价格-地址-卖家编号-买家编号-商品名称
        address=addressDao.getAddress(buyer.getBid());
        ordersDao.addOrdersRepository("待付款",goods.getGid(),goods.getGprices(),address.getPstate(),goods.getSid(), buyer.getBid(),goods.getGname());
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", buyer);
        return "index2";
    }
  //--------投诉----------
    //投诉操作
    @PostMapping("complain")
    public String complain(Model model,String Ccontent,String Cstate){
        model.addAttribute("loginUser", buyer);
        System.out.print(Ccontent);
        complainDao.addComplainRepository(buyer.getBid(),Ccontent, Cstate);
        return "complain";
    }
    //进入投诉界面
    @GetMapping("complain")
    public String complain (Model model){
        model.addAttribute("loginUser", buyer);
        return "complain";
    }
    //买家查看投诉结果
    @GetMapping("complain_results")
    public String complain_results(Model model){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("ComplainList",complainDao.findByBID(buyer.getBid()));
        return "complain_results";
    }
    //处理结果表
    @GetMapping("complain_results_detail")
    public String complain_results_detail(Model model,String KID){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("service",ServiceDao.findNameByKID(KID));
        model.addAttribute("ComplainList",complainDao.findByBID(buyer.getBid()));
        return "complain_results_detail";
    }
}
