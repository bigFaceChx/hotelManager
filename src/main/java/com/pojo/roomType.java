package com.pojo;

public class roomType {
    private int roomType;
    private String name;
    private int price;
    private  int oldRoomType;

    public int getOldRoomType() {
        return oldRoomType;
    }

    public void setOldRoomType(int oldRoomType) {
        this.oldRoomType = oldRoomType;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "roomType{" +
                "roomType=" + roomType +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
