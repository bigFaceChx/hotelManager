package com.controller;

import com.dao.roomTypeMapper;
import com.pojo.room;
import com.pojo.roomType;
import com.service.registerService;
import com.service.roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class roomController {
    @Autowired
    private roomService roomService;
    @Autowired
    private com.service.registerService registerService;
    @Autowired
    private com.dao.roomTypeMapper roomTypeMapper;

    @RequestMapping("RoomFind")
    @ResponseBody
    public List<room> RoomFind(){
        List<room> list=roomService.RoomFind();
        return list;
    }
    @RequestMapping("RoomFindAndState")
    @ResponseBody
    public List<room> RoomFindAndState(HttpServletRequest request){
        String state = request.getParameter("state");
        List<room> list=roomService.RoomFindAndState(state);
        return list;
    }
    //退房
    @RequestMapping("tuifang")
    public String tuifang(HttpServletRequest request){
        String rid=request.getParameter("rid");
        //为该订单添加退房时间
        String endTime=roomController.getTime();
        int tui=registerService.tuifang(rid,endTime);
        System.out.println(tui);
        //改变当前房间状态为空闲
        try{
            roomService.changeState("空闲",rid);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return "chaxun";
    }
    //查询所有房间类型
    @RequestMapping("findRoomType")
    @ResponseBody
    public List<roomType> findRoomType(){
        List<roomType> list=roomTypeMapper.findRoomType();
        return list;
    }
    //添加房间类型
    @RequestMapping("addRoomType")
    public String addRoomType(roomType roomType){
        roomTypeMapper.addRoomType(roomType);
        return "roomType";
    }
    //修改房间类型
    @RequestMapping("updateRoomType")
    public String updateRoomType(roomType rt,String oldRt){
        System.out.println(rt);
        System.out.println(oldRt);

        roomTypeMapper.updateRoomType(rt,Integer.parseInt(oldRt));

        return "roomType";
    }
    //添加房间
    @RequestMapping("addRoom")
    public String addRoom(HttpServletRequest request,MultipartFile img){
        String rid=request.getParameter("rid");
        String roomType=request.getParameter("roomType");
        String bedNum=request.getParameter("bedNum");
        System.out.println(img);
        String name=img.getOriginalFilename()+new Date().getTime();

        //System.out.println(name);
        //上传该文件到服务器img/room文件夹下
        if (name!=""||img.getSize()!=0){
            HttpSession session = request.getSession();
            ServletContext servletContext = session.getServletContext();
            String realPath = servletContext.getRealPath("/img/room");
            String path=realPath+"/"+name;
            System.out.println(path);
            try {
                img.transferTo(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //添加房间
        roomService.addRoom(Integer.parseInt(rid),Integer.parseInt(roomType),bedNum,"img/room/"+name);
        System.out.println("--");
        return "chaxun";
    }

    //删除房间
    @RequestMapping("delRoom")
    public String delRoom(room room){
        roomService.delRoom(room);
        return "chaxun";
    }
    //根据rid查询房间
    @RequestMapping("findRoomById")
    @ResponseBody
    public room findRoomById(room room){
        room r=roomService.findRoomById(room);
        return r;
    }
    //修改房间数据
    @RequestMapping("updateRoom")
    public String updateRoom(HttpServletRequest request,room room,MultipartFile roomImg){
        String name=roomImg.getOriginalFilename();
        //System.out.println(name);
        //上传该文件到服务器img/room文件夹下
        System.out.println(name);
        String img="";
        if (name!=""||roomImg.getSize()!=0){
            name+=new Date().getTime();
            HttpSession session = request.getSession();
            ServletContext servletContext = session.getServletContext();
            String realPath = servletContext.getRealPath("/img/room");
            String path=realPath+"/"+name;
            System.out.println(path);
            try {
                roomImg.transferTo(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
            img="img/room/"+name;
        }
        if (img!=""){
            room.setImg(img);
        }else {
            room.setImg(null);
        }
        String oldRid=request.getParameter("oldRid");
        System.out.println(oldRid);
        System.out.println(room);
        roomService.updateRoom(room,Integer.parseInt(oldRid));
        return "chaxun";

    }
    //获取当前时间（string）
    private static String getTime() {
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return  format;
    }


}
