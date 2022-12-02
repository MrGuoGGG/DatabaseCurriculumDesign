package com.gyx.pojo;

public class S_User {
    private String sid;
    private String sname;
    private String spassword;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    @Override
    public String toString() {
        return "S_User{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", spassword='" + spassword + '\'' +
                '}';
    }
}
