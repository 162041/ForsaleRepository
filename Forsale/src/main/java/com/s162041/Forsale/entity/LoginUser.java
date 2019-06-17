package com.s162041.Forsale.entity;

public class LoginUser {
    private String BID;
    private String Bname;
    private String Bpassword;
    private String Btel;
    private String Bpicture;

    public LoginUser(String name, String password) {
        this.Bname = name;
        this.Bpassword = password;
    }

    public LoginUser() { }

    public String getBID() {
        return BID;
    }

    public void setBID(String BID) {
        this.BID = BID;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public String getBpassword() {
        return Bpassword;
    }

    public void setBpassword(String bpassword) {
        Bpassword = bpassword;
    }

    public String getBtel() {
        return Btel;
    }

    public void setBtel(String btel) {
        Btel = btel;
    }

    public String getBpicture() {
        return Bpicture;
    }

    public void setBpicture(String bpicture) {
        Bpicture = bpicture;
    }
}
