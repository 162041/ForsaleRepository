package com.s162041.Forsale.entity;


public class Goods {

  private long gid;
  private java.sql.Date gdate;
  private String gprices;
  private String sid;
  private String gname;
  private String gdescribe;
  private String gpicture;


  public java.sql.Date getGdate() {
    return gdate;
  }

  public void setGdate(java.sql.Date gdate) {
    this.gdate = gdate;
  }


  public String getGprices() {
    return gprices;
  }

  public void setGprices(String gprices) {
    this.gprices = gprices;
  }


  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }


  public String getGdescribe() {
    return gdescribe;
  }

  public void setGdescribe(String gdescribe) {
    this.gdescribe = gdescribe;
  }


  public String getGpicture() {
    return gpicture;
  }

  public void setGpicture(String gpicture) {
    this.gpicture = gpicture;
  }

public long getGid() {
	return gid;
}

public void setGid(long gid) {
	this.gid = gid;
}

}
