package com.gyx.pojo;

public class Book {
    private String bid;
    private String bname;
    private String bauthor;
    private String blanguage;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBlanguage() {
        return blanguage;
    }

    public void setBlanguage(String blanguage) {
        this.blanguage = blanguage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", blanguage='" + blanguage + '\'' +
                '}';
    }
}
