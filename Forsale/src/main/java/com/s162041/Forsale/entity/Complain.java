package com.s162041.Forsale.entity;


public class Complain {

  private String cid;
  private String kid;
  private String sid;
  private String bid;
  private java.sql.Date cdate;
  private String ccontent;
  private String cstate;


  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }


  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }


  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getBid() {
    return bid;
  }

  public void setBid(String bid) {
    this.bid = bid;
  }


  public java.sql.Date getCdate() {
    return cdate;
  }

  public void setCdate(java.sql.Date cdate) {
    this.cdate = cdate;
  }


  public String getCcontent() {
    return ccontent;
  }

  public void setCcontent(String ccontent) {
    this.ccontent = ccontent;
  }


  public String getCstate() {
    return cstate;
  }

  public void setCstate(String cstate) {
    this.cstate = cstate;
  }

}
