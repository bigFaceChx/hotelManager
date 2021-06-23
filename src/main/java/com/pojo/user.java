package com.pojo;

public class user {
    //用户编号
    private int uNumber;
    //用户姓名
    private String uName;
    //用户身份证号
    private String IdCard;
    //用户住址
    private String address;


    public user() {
    }

    public int getuNumber() {
        return uNumber;
    }

    public void setuNumber(int uNumber) {
        this.uNumber = uNumber;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "user{" +
                "uNumber=" + uNumber +
                ", uName='" + uName + '\'' +
                ", IdCard='" + IdCard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
