package com.s162041.Forsale.entity;


import java.util.Date;

public class Orders {

  private String oid;
  private String ostate;
  private String gid;
  private String gprices;
  private String pstate;
  private String sid;
  private String bid;
  private Date odate;
  private String gname;


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


  public String getPstate() {
    return pstate;
  }

  public void setPstate(String pstate) {
    this.pstate = pstate;
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


  public Date getOdate() {
    return odate;
  }

  public void setOdate(Date odate) {
    this.odate = odate;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

}
