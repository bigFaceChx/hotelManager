package com.service;

import com.pojo.room;

import java.util.List;

public interface roomService {

    List<room> RoomFind();

    List<room> RoomFindAndState(String state);

    void changeState(String state,String rid);

    void addRoom(int rid, int roomType, String bedNum, String s);

    void delRoom(room room);

    room findRoomById(room room);

    void updateRoom(room room,int oldRid);
}
