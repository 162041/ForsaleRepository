package com.s162041.Forsale.entity;


import java.util.Date;

public class Announcement {

  private String nid;
  private String aname;
  private String ncontent;
  private Date ndate;
  private String nstate;


  public String getNid() {
    return nid;
  }

  public void setNid(String nid) {
    this.nid = nid;
  }

  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }

  public String getNcontent() {
    return ncontent;
  }

  public void setNcontent(String ncontent) {
    this.ncontent = ncontent;
  }


  public Date getNdate() {
    return ndate;
  }

  public void setNdate(Date ndate) {
    this.ndate = ndate;
  }

  public String getNstate() {
    return nstate;
  }

  public void setNstate(String nstate) {
    this.nstate = nstate;
  }

}
