package com.s162041.Forsale.entity;


public class Complain {

  private int cid;
  private String kid;
  private String bid;
  private java.sql.Date cdate;
  private String ccontent;
  private String cstate;
  private String cback;


  public String getCback() {
	return cback;
}

public void setCback(String cback) {
	this.cback = cback;
}



  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
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

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

}
