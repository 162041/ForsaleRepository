package com.s162041.Forsale.entity;

public class LoginAdmin {
    private String AID;
    private String Aname;
    private String Apassword;
    private String Atel;
    private String Apicture;

    public LoginAdmin(String aname, String apassword) {
        Aname = aname;
        Apassword = apassword;
    }

    public LoginAdmin() {
    }

    public String getAname() {
        return Aname;
    }

    public void setAname(String Aname) {
        this.Aname = Aname;
    }

    public String getApassword() {
        return Apassword;
    }

    public void setApassword(String Apassword) {
        this.Apassword = Apassword;
    }

    public String getAtel() {
        return Atel;
    }

    public void setAtel(String atel) {
        Atel = atel;
    }

    public String getApicture() {
        return Apicture;
    }

    public void setApicture(String apicture) {
        Apicture = apicture;
    }

    public String getAID() {
        return AID;
    }

    public void setAID(String AID) {
        this.AID = AID;
    }
}
