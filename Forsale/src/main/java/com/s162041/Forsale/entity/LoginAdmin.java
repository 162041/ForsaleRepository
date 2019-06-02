package com.s162041.Forsale.entity;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019/6/2
 * 主要功能说明 ……
 */
public class LoginAdmin {
    private String Aname;
    private String Apassword;

    public LoginAdmin(String Aname, String Apassword) {
        this.Aname = Aname;
        this.Apassword = Apassword;
    }

    public LoginAdmin() {
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String Aname) {
        this.Aname = Aname;
    }

    public String getApassword() {
        return Apassword;
    }

    public void setApassword(String Apassword) {
        this.Apassword = Apassword;
    }
}
