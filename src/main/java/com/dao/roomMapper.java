package com.dao;

import com.pojo.room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface roomMapper {
    List<room> RoomFind();
    List<room> RoomFindAndState(String state);
    void changeState(@Param("state") String state, @Param("rid") String rid);
    void addRoom(@Param("rid") int rid, @Param("roomType") int roomType, @Param("bedNum") String bedNum, @Param("img") String img);
    void delRoom(room room);

    room findRoomById(room room);

    void updateRoom(@Param("room") room room,@Param("oldRid") int oldRid);
}
