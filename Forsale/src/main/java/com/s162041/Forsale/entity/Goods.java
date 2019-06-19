package com.s162041.Forsale.entity;

import java.sql.Date;

public class Goods {
    private String GID;//商品编号
    private String Gname;//商品名称
    private String Gprices;//商品价格
    private String Gtype;//商品类型
    private Date Gdate;//商品发布日期
    private String Gdescribe;//商品描述
    private String Gpicture;//商品图片地址
    private String SID;//卖家编号

    public Goods(String GID, String gname, String gprices, String gtype, String gdescribe, String gpicture, String SID) {
        this.GID = GID;
        Gname = gname;
        Gprices = gprices;
        Gtype = gtype;
        Gdescribe = gdescribe;
        Gpicture = gpicture;
        this.SID = SID;
    }

    public Goods() {}

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getGprices() {
        return Gprices;
    }

    public void setGprices(String gprices) {
        Gprices = gprices;
    }

    public String getGdescribe() {
        return Gdescribe;
    }

    public void setGdescribe(String gdescribe) {
        Gdescribe = gdescribe;
    }

    public String getGpicture() {
        return Gpicture;
    }

    public void setGpicture(String gpicture) {
        Gpicture = gpicture;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getGname() {
        return Gname;
    }

    public void setGname(String gname) {
        Gname = gname;
    }

    public String getGtype() {
        return Gtype;
    }

    public void setGtype(String gtype) {
        Gtype = gtype;
    }


    public Date getGdate() {
        return Gdate;
    }

    public void setGdate(Date gdate) {
        Gdate = gdate;
    }
}
