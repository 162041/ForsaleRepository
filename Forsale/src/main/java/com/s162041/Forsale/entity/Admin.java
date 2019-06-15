package com.s162041.Forsale.entity;


public class Admin {

  private String aid;
  private String aname;
  private String apassword;
  private String atel;
  private String apicture;

  public Admin(String aname, String apassword) {
    this.aname = aname;
    this.apassword = apassword;
  }

  public String getAid() {
    return aid;
  }

  public void setAid(String aid) {
    this.aid = aid;
  }


  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }


  public String getApassword() {
    return apassword;
  }

  public void setApassword(String apassword) {
    this.apassword = apassword;
  }


  public String getAtel() {
    return atel;
  }

  public void setAtel(String atel) {
    this.atel = atel;
  }


  public String getApicture() {
    return apicture;
  }

  public void setApicture(String apicture) {
    this.apicture = apicture;
  }

}
