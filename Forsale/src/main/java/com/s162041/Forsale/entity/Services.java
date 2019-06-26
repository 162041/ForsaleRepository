package com.s162041.Forsale.entity;


public class Services {

  private String kid;
  private String ktel;
  private String kpassword;
  private String kname;

  public Services(String kname, String kpassword) {
    this.kpassword = kpassword;
    this.kname = kname;
  }

  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }


  public String getKtel() {
    return ktel;
  }

  public void setKtel(String ktel) {
    this.ktel = ktel;
  }


  public String getKpassword() {
    return kpassword;
  }

  public void setKpassword(String kpassword) {
    this.kpassword = kpassword;
  }


  public String getKname() {
    return kname;
  }

  public void setKname(String kname) {
    this.kname = kname;
  }

}
