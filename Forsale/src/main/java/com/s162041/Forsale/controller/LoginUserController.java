package com.s162041.Forsale.controller;


import com.s162041.Forsale.dao.GoodsRepository;
import com.s162041.Forsale.dao.LoginUserRepository;
import com.s162041.Forsale.dao.OrdersRepository;
import com.s162041.Forsale.dao.SellerRepository;
import com.s162041.Forsale.entity.Goods;
import com.s162041.Forsale.entity.LoginUser;
import com.s162041.Forsale.entity.Seller;
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
    private LoginUserRepository loginUserDao;
    @Autowired
    private SellerRepository sellerDao;
    @Autowired
    private GoodsRepository goodsDao;
    @Autowired
    private OrdersRepository ordersDao;
    private List<Goods> goodsList;
    private LoginUser loginUser;
    private Seller seller;
    private Goods goods;
    //---------游客----------
    //游客访问
    @GetMapping("/")
    public String visitor(Model model,String Gtype){
        goodsList=goodsDao.findByType(Gtype);
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
    public String register(Model model,String Bname,String Bpassword,String Btel){
        String ID=String.valueOf((int)(Math.random()*9999999));//生成ID
        loginUserDao.addLoginUser(ID,Bname,Bpassword,Btel);
        loginUser = loginUserDao.getLoginUser(Bname,Bpassword);
        sellerDao.addSeller(ID,Bname,Bpassword,Btel);
        model.addAttribute("loginUser", loginUser);
        return "index2";
    }
    //登陆界面
    @GetMapping("login")
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
            System.out.println("用户名或密码错误!请重新登录");
            model.addAttribute("msg","密码错误");
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
    //搜索框模糊查询
    @PostMapping("search")
    public String search(Model model,String Gname){
        System.out.println("index:"+loginUser.getBname());
        model.addAttribute("goodsList",goodsDao.findByName(Gname));
        model.addAttribute("loginUser", loginUser);
        return "category_pages";
    }
    //个人信息界面
    @GetMapping("personal_information")
    public String personal_information(Model model){
        model.addAttribute("loginUser", loginUser);
        System.out.println(loginUser.getBname());
        return "personal_information";
    }
    @PostMapping("personal_information")
    public String change_personal_information(Model model,String Bname,String Atel,String Pstate){
        loginUserDao.setLoginUser(loginUser.getBID(),Bname,Atel,Pstate);
        //更新loginUser
        loginUser = loginUserDao.getLoginUser(Bname,loginUser.getBpassword( ));
        model.addAttribute("loginUser", loginUser);
        System.out.println("Pstate"+Pstate);
        return "personal_information";
    }

    //发布商品界面
    @GetMapping("release_goods")
    public String release_goods(Model model){
        model.addAttribute("loginUser", loginUser);
        System.out.println(loginUser.getBname());
        return "release_goods";
    }
    //发布商品操作
    @PostMapping("release_goods")
    public String release_goods_submit(Model model, String Gname, String Gdescribe, String Gprices, String Gtype, MultipartFile filename)throws Exception{
        System.out.println("#"+Gname+"#"+Gprices+"#"+Gtype+"#"+Gdescribe+"#"+filename.getOriginalFilename()+"#"+loginUser.getBID());
        String str="images/"+filename.getOriginalFilename();
        filename.transferTo(new File("D:/GitHub/ForsaleRepository/Forsale/src/main/resources/static/"+str));
        model.addAttribute("loginUser", loginUser);
        goodsDao.addGoodsRepository(Gname,Gprices,Gtype,Gdescribe,str,loginUser.getBID());
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
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", loginUser);
        return "goods_details";
    }
    //生产订单操作
    @PostMapping("goods_details")
    public String orders (Model model){
        System.out.println("Gname为"+goods.getGname());
        //订单状态-商品编号-商品价格-地址-卖家编号-买家编号-商品名称
        ordersDao.addOrdersRepository("待付",goods.getGID(),goods.getGprices(),"南昌前湖大道","00001",loginUser.getBID(),goods.getGname());
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", loginUser);
        return "index2";
    }
    //买家查看已购买商品
    @GetMapping("purchase_orders")
    public String purchase_orders (Model model){
        ordersDao.findOrdersByBID(loginUser.getBID());
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("ordersList",ordersDao.findOrdersByBID(loginUser.getBID()));
        return "purchase_orders";
    }
    //卖家查看已发布的商品
    @GetMapping("released")
    public String released(Model model){
        model.addAttribute("loginUser", loginUser);
        model.addAttribute("goodsList",goodsDao.findAllByBID(loginUser.getBID()));
        return "released";
    }
}
