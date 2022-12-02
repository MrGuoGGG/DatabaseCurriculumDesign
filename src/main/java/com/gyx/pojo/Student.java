package com.gyx.pojo;

public class Student {
    private String sid;
    private String sname;
    private String sgender;
    private String sage;
    private String smajor;
    private int sbnum;

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

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public int getSbnum() {
        return sbnum;
    }

    public void setSbnum(int sbnum) {
        this.sbnum = sbnum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sage='" + sage + '\'' +
                ", smajor='" + smajor + '\'' +
                ", sbnum=" + sbnum +
                '}';
    }
}
