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
    //---------锟轿匡拷----------
    //锟轿客凤拷锟斤拷
    @GetMapping("/")
    public String visitor(Model model,String Gtype){
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("AnnouncementList",announcementDao.findAll());
        model.addAttribute("goodsList",goodsList);
        return "index1";
    }
    //锟斤拷页锟斤拷品
    @GetMapping("visitor_category_pages")
    public String visitor_category_pages (Model model,String Gtype){
        System.out.println(Gtype);
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("goodsList",goodsList);
        return "visitor_category_pages";
    }
    //锟斤拷品锟斤拷锟斤拷
    @GetMapping("visitor_goods_details")
    public String visitor_goods_details (Model model,String GID){
        System.out.println(GID);
        goods=goodsDao.findByGID(GID);
        model.addAttribute("goods",goods);
        return "visitor_goods_details";
    }
    //锟斤拷锟斤拷锟斤拷模锟斤拷锟斤拷询
    @PostMapping("visitor_search")
    public String visitor_search(Model model,String Gname){
        model.addAttribute("goodsList",goodsDao.findByName(Gname));
        return "visitor_category_pages";
    }
    //---------锟轿匡拷----------
    //--------锟斤拷锟斤拷莸锟铰�-----
    //注锟斤拷
    @PostMapping("register")
    public String register(Model model,String Bname,String Bpassword,String Btel,String pstate){
        String ID=String.valueOf((int)(Math.random()*9999999));//锟斤拷锟斤拷ID
        loginUserDao.addLoginUser(ID,Bname,Bpassword,Btel);
        buyer = loginUserDao.getLoginUser(Bname,Bpassword);
        addressDao.addAddress(buyer.getBid(), pstate);
        sellerDao.addSeller(ID,Bname,Bpassword,Btel);
        model.addAttribute("loginUser", buyer);
        return "index2";
    }
    //锟斤拷陆锟斤拷锟斤拷
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
                System.out.println("锟缴癸拷");
                return "index2";
            } else {
                System.out.println("锟剿猴拷锟斤拷锟诫不匹锟斤拷");
                return "login";
            }
        } catch (Exception e) {
            System.out.println("锟矫伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�!锟斤拷锟斤拷锟铰碉拷录");
            model.addAttribute("msg","锟斤拷锟斤拷锟斤拷锟�");
            return "login";
        }
    }
    //锟斤拷页
    @GetMapping("index")
    public String index(Model model){
        System.out.println("Ncontent:"+(announcementDao.findAll().get(0).getNcontent()));
        model.addAttribute("loginUser", buyer);
        model.addAttribute("AnnouncementList",announcementDao.findAll());
        return "index2";
    }
    //锟斤拷锟斤拷锟斤拷模锟斤拷锟斤拷询
    @PostMapping("search")
    public String search(Model model,String Gname){
        System.out.println("index:"+ buyer.getBname());
        model.addAttribute("goodsList",goodsDao.findByName(Gname));
        model.addAttribute("loginUser", buyer);
        return "category_pages";
    }
    //锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷
    @GetMapping("personal_information")
    public String personal_information(Model model){
        model.addAttribute("loginUser", buyer);
        address=addressDao.getAddress(buyer.getBid());
        model.addAttribute("address",address);
        System.out.println("address:"+address);
        return "personal_information";
    }
    //锟睫改革拷锟斤拷锟斤拷息
    @PostMapping("personal_information")
    public String change_personal_information(Model model,String Bname,String Atel,String Pstate){
        loginUserDao.setLoginUser(buyer.getBid(),Bname,Atel,Pstate);
        address=addressDao.getAddress(buyer.getBid());
        //锟斤拷锟斤拷loginUser
        buyer = loginUserDao.getLoginUser(Bname, buyer.getBpassword( ));
        model.addAttribute("loginUser", buyer);
        //锟斤拷锟铰碉拷址
        addressDao.setAddress(buyer.getBid(), Pstate);
        model.addAttribute(address);
        System.out.println("Pstate"+Pstate);
        return "personal_information";
    }
    //--------锟斤拷品----------
    //锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷
    @GetMapping("release_goods")
    public String release_goods(Model model){
        model.addAttribute("loginUser", buyer);
        System.out.println(buyer.getBname());
        return "release_goods";
    }
    //锟斤拷锟斤拷锟斤拷品锟斤拷锟斤拷
    @PostMapping("release_goods")
    public String release_goods_submit(Model model, String Gname, String Gdescribe, String Gprices, String Gtype, MultipartFile filename)throws Exception{
        System.out.println("#"+Gname+"#"+Gprices+"#"+Gtype+"#"+Gdescribe+"#"+filename.getOriginalFilename()+"#"+ buyer.getBid());
        String str="images/"+filename.getOriginalFilename();
        filename.transferTo(new File("E:/GitHub/ForsaleRepository/Forsale/src/main/resources/static/"+str));
        model.addAttribute("loginUser", buyer);
        goodsDao.addGoodsRepository(Gname,Gprices,Gtype,Gdescribe,str, buyer.getBid());
        return "index2";
    }
    //删锟斤拷锟斤拷品
    @GetMapping("delete_goods")
    public String delete_goods_submit(Model model,String GID){
        model.addAttribute("loginUser", buyer);
        goodsDao.deleteGoodsRepository(GID);
        model.addAttribute("goodsList",goodsDao.findAllByBID(buyer.getBid()));
        return "released";
    }
    //锟斤拷页锟斤拷品
    @GetMapping("category_pages")
    public String category_pages (Model model,String Gtype){
        System.out.println(Gtype);
        model.addAttribute("loginUser", buyer);
        goodsList=goodsDao.findByType(Gtype);
        model.addAttribute("goodsList",goodsList);
        return "category_pages";
    }
    //锟斤拷也榭达拷压锟斤拷锟斤拷锟狡�
    @GetMapping("purchase_orders")
    public String purchase_orders (Model model){
        ordersDao.findOrdersByBID(buyer.getBid());
        model.addAttribute("loginUser", buyer);
        model.addAttribute("ordersList",ordersDao.findOrdersByBID(buyer.getBid()));
        return "purchase_orders";
    }
    //锟斤拷锟揭查看锟窖凤拷锟斤拷锟斤拷锟斤拷品
    @GetMapping("released")
    public String released(Model model){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("goodsList",goodsDao.findAllByBID(buyer.getBid()));
        return "released";
    }
   //锟斤拷锟揭查看锟斤拷锟桔筹拷锟斤拷锟斤拷品
    @GetMapping("sold")
    public String sold(Model model){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("ordersList",ordersDao.findOrdersByOstateAndBID("锟窖筹拷锟斤拷",buyer.getBid()));
        return "sold";
    }
    //--------锟斤拷锟斤拷----------
    //锟斤拷锟斤拷锟斤拷细锟斤拷锟斤拷页锟斤拷
    @GetMapping("goods_details")
    public String goods_details (Model model,String GID){
        System.out.println(GID);
        goods=goodsDao.findByGID(GID);
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", buyer);
        return "goods_details";
    }
    //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
    @PostMapping("goods_details")
    public String orders (Model model){
        System.out.println("Gname为"+goods.getGname());
        //锟斤拷锟斤拷状态-锟斤拷品锟斤拷锟�-锟斤拷品锟桔革拷-锟斤拷址-锟斤拷锟揭憋拷锟�-锟斤拷冶锟斤拷-锟斤拷品锟斤拷锟斤拷
        address=addressDao.getAddress(buyer.getBid());
        ordersDao.addOrdersRepository("待付款",goods.getGid(),goods.getGprices(),address.getPstate(),goods.getSid(), buyer.getBid(),goods.getGname());
        model.addAttribute("goods",goods);
        model.addAttribute("loginUser", buyer);
        return "index2";
    }
  //--------投锟斤拷----------
    //投锟竭诧拷锟斤拷
    @PostMapping("complain")
    public String complain(Model model,String Ccontent,String Cstate){
        model.addAttribute("loginUser", buyer);
        System.out.print(Ccontent);
        complainDao.addComplainRepository(buyer.getBid(),Ccontent, Cstate);
        return "complain";
    }
    //锟斤拷锟斤拷投锟竭斤拷锟斤拷
    @GetMapping("complain")
    public String complain (Model model){
        model.addAttribute("loginUser", buyer);
        return "complain";
    }
    //锟斤拷也榭赐讹拷呓锟斤拷
    @GetMapping("complain_results")
    public String complain_results(Model model){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("ComplainList",complainDao.findByBID(buyer.getBid()));
        return "complain_results";
    }
    //锟斤拷锟斤拷锟斤拷锟斤拷
    @GetMapping("complain_results_detail")
    public String complain_results_detail(Model model,String KID){
        model.addAttribute("loginUser", buyer);
        model.addAttribute("service",ServiceDao.findNameByKID(KID));
        model.addAttribute("ComplainList",complainDao.findByBID(buyer.getBid()));
        return "complain_results_detail";
    }
}
