package com.s162041.Forsale.controller;

import com.s162041.Forsale.dao.AdminDao;
import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.entity.Announcement;
import com.s162041.Forsale.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

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
	/*
	* 跳转编辑修改个人信息页面
	* */
	@Resource
	private AdminService adminService;
    @RequestMapping("showEdit")
    public ModelAndView showEdit() {
    	ModelAndView mv=new ModelAndView("editadmin");
    	return mv;
    }
    /*
    * 保存修改个个人信息
    * */
	@RequestMapping("editAdmin")
    public String editAdmin(Admin admin, HttpServletRequest request){
        String aid = request.getParameter("aid");
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
        String atel = request.getParameter("atel");
        admin.setAid(aid);
        admin.setAname(aname);
        admin.setApassword(apassword);
        admin.setAtel(atel);
    	adminService.editAdmin(admin);
        return "admin_service_login";
    }
    /*
    * 获取所有公告
    * */
    @RequestMapping("getAnnounceList")
    public ModelAndView getAnnounceList(){
        ModelAndView mv = new ModelAndView("showAnnouncement");
        List<Announcement> list =adminService.getAnnounceList();
        mv.addObject("list",list);
        return  mv;
    }
    /*
    * 跳转发布公告页面
    * */
    @RequestMapping("sendAnnouncement")
    public String sendAnnouncement(){
        return "editAnnouncement";
    }
    /*
    * 保存发布公告
    * */
    @RequestMapping("editAnnouncement")
    public String editAnnouncement(Announcement announcement,HttpServletRequest request){
        String nid = request.getParameter("nid");
        String aname = request.getParameter("aname");
        String ncontent =request.getParameter("ncontent");
        String nstate =request.getParameter("nstate");
        announcement.setAname(aname);
        announcement.setNcontent(ncontent);
        announcement.setNstate(nstate);
        announcement.setNdate(new Date());
        //判断公告id是否为空
        if(nid==null){//nid为空则发布一条新公告
        adminService.saveAnnouncement(announcement);
        }else {//查询到nid则修改此公告
            announcement.setNid(nid);
            adminService.updateAnnounceById(announcement);
        }
        return "showAnnouncement";
    }
    /*
    * 通过nid查找已保存的公告
    * @param nid  ,公告id
    * */
    @RequestMapping("getAnnounceListById")
    public String getAnnounceListById(String nid,Model model){
        Announcement announcement=adminService.getAnnounceListById(nid);
        model.addAttribute("announcement",announcement);
        return "editAnnouncementById";
    }
    //根据nid删除公告
    @RequestMapping("deleteAnnouncement")
    public String deleteAnnouncement(String nid){
        adminService.deleteAnnouncement(nid);
        return "showAnnouncement";
    }


}
