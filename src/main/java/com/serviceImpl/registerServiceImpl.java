package com.serviceImpl;

import com.dao.registerMapper;
import com.dao.roomMapper;
import com.dao.userMapper;
import com.pojo.register;
import com.pojo.registerTwo;
import com.pojo.user;
import com.service.registerService;
import com.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class registerServiceImpl implements registerService {
    @Autowired
    private registerMapper registerMapper;
    @Autowired
    private userMapper userMapper;
    @Autowired
    private com.dao.roomMapper roomMapper;

    //退房
    @Override
    public int tuifang(String rid, String reid) {
        //改变房间状态
        roomMapper.changeState("空闲",rid);
        //为该订单添加结束时间
        String time = registerServiceImpl.getTime();
        int x = registerMapper.addEndTime(rid, time);
        return x;
    }

    private static String getTime() {
        Date data = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data);
        return format;
    }

    @Override
    public void registerService(int reid) {
        registerMapper.registerMapper(reid);
    }

    @Override
    public List<registerTwo> findRegister() {
        List<registerTwo> list = registerMapper.findRegister();
        return list;
    }

    @Override
    public void ruzhu(String rid, String uName, String idCard, String number, String day) {
        System.out.println("-----impl--ruzhu-----");
        //添加用户
        user user = new user();
        user.setuName(uName);
        user.setIdCard(idCard);
        System.out.println(user);
        userMapper.insertUser(user);
        int uNumber = user.getuNumber();
        System.out.println(uNumber);
        //添加入住记录
        register register = new register();
        register.setRid(Integer.parseInt(rid));
        register.setUid(uNumber);
        String time = registerServiceImpl.getTime();
        register.setStartTime(time);
        register.setNumber(Integer.parseInt(number));
        registerMapper.ruzhu(register);
        //修改房间状态为使用中
        roomMapper.changeState("正在使用", rid);

    }
}

