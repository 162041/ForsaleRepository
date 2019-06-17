package com.s162041.Forsale.entity;


public class Announcement {

  private String nid;
  private String aid;
  private String ncontent;
  private java.sql.Date ndate;
  private String nstate;


  public String getNid() {
    return nid;
  }

  public void setNid(String nid) {
    this.nid = nid;
  }


  public String getAid() {
    return aid;
  }

  public void setAid(String aid) {
    this.aid = aid;
  }


  public String getNcontent() {
    return ncontent;
  }

  public void setNcontent(String ncontent) {
    this.ncontent = ncontent;
  }


  public java.sql.Date getNdate() {
    return ndate;
  }

  public void setNdate(java.sql.Date ndate) {
    this.ndate = ndate;
  }


  public String getNstate() {
    return nstate;
  }

  public void setNstate(String nstate) {
    this.nstate = nstate;
  }

}
