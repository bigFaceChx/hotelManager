package com.pojo;

import java.util.Date;

public class register {
    //记录编号
    private int reid;
    //房间号
    private int rid;
    //用户编号
    private int uid;
    //入住时间
    private String startTime;
    //结束时间
    private String endTime;
    //入住人数
    private int number;

    public register() {
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "register{" +
                "rid=" + rid +
                ", uid=" + uid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", number=" + number +
                '}';
    }
}
