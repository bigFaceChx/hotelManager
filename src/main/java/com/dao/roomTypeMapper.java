package com.dao;

import com.pojo.room;
import com.pojo.roomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface roomTypeMapper {

    List<roomType> findRoomType();

    void addRoomType(roomType roomType);

    void updateRoomType(@Param("rt") roomType rt,@Param("oldRoomType") int oldRoomType);
}
