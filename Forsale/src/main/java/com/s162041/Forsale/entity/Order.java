package com.s162041.Forsale.entity;


public class Order {

  private String oid;
  private String ostate;
  private String kid;
  private String aid;
  private String gid;
  private String gprices;
  private String pid;
  private String sid;
  private String bid;
  private java.sql.Date odate;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public String getOstate() {
    return ostate;
  }

  public void setOstate(String ostate) {
    this.ostate = ostate;
  }


  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }


  public String getAid() {
    return aid;
  }

  public void setAid(String aid) {
    this.aid = aid;
  }


  public String getGid() {
    return gid;
  }

  public void setGid(String gid) {
    this.gid = gid;
  }


  public String getGprices() {
    return gprices;
  }

  public void setGprices(String gprices) {
    this.gprices = gprices;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
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


  public java.sql.Date getOdate() {
    return odate;
  }

  public void setOdate(java.sql.Date odate) {
    this.odate = odate;
  }

}
