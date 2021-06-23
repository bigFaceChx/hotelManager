package com;

import com.dao.registerMapper;
import com.dao.userMapper;
import com.pojo.register;
import com.pojo.user;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-public.xml");
        userMapper userMapper = (userMapper)context.getBean("userMapper");
        user user = new user();
        user.setuName("chx");
        user.setIdCard("4561234561");
        userMapper.insertUser(user);
        System.out.println(user.getuNumber());
        /*registerMapper registerMapper = (com.dao.registerMapper)context.getBean("registerMapper");
        register register = new register();
        register.setRid(1001);
        register.setUid(1);
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        register.setStartTime(format);
        register.setNumber(2);
        registerMapper.ruzhu(register);*/


    }
}
