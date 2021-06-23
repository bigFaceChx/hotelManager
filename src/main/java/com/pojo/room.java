package com.pojo;

public class room {
    //房间编号
    private int rid;
    //房间类型
    private String roomType;
    //床的数量
    private int bedNum;
    //价格
    private int price;
    //状态
    private String state;
    //房间图片
    private String img;

    public room() {
    }
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "room{" +
                "rid=" + rid +
                ", roomType=" + roomType +
                ", bedNum=" + bedNum +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
