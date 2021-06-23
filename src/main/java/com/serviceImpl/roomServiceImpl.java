package com.serviceImpl;

import com.dao.roomMapper;
import com.pojo.room;
import com.pojo.user;
import com.service.roomService;
import com.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class roomServiceImpl implements roomService {
    @Autowired
    private roomMapper roomMapper;

    @Override
    public List<room> RoomFind() {
        List<room> list=roomMapper.RoomFind();
        return list;
    }

    @Override
    public void changeState(String state,String rid) {
        roomMapper.changeState(state,rid);
    }

    @Override
    public void updateRoom(room room,int oldRid) {
        roomMapper.updateRoom(room,oldRid);
    }

    @Override
    public room findRoomById(room room) {
        room r=roomMapper.findRoomById(room);
        return r;
    }

    @Override
    public void delRoom(room room) {
        roomMapper.delRoom(room);
    }

    @Override
    public void addRoom(int rid, int roomType, String bedNum, String s) {
        roomMapper.addRoom(rid,roomType,bedNum,s);
    }

    @Override
    public List<room> RoomFindAndState(String state) {
        List<room> list=roomMapper.RoomFindAndState(state);
        return list;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-public.xml");
        roomService roomService = (roomService)context.getBean(roomServiceImpl.class);
        System.out.println(roomService);
        List<room> list = roomService.RoomFind();
        System.out.println(list);
    }
}
