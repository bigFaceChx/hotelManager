package com.serviceImpl;

import com.dao.userMapper;
import com.pojo.user;
import com.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-public.xml");
        userService userService = (userService)context.getBean(userServiceImpl.class);

    }


}
