package com.controller;

import com.pojo.registerTwo;
import com.service.registerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class registerController {
    @Autowired
    private registerService registerService;
    //入住
    @RequestMapping("ruzhu")
    public void ruzhu(HttpServletRequest request){
        //房间号
        String rid = request.getParameter("rid");
        //客户姓名
        String uName = request.getParameter("uName");
        //客户身份证
        String IdCard = request.getParameter("IdCard");
        //入住人数
        String number = request.getParameter("number");
        //入住天数
        String day = request.getParameter("day");
        System.out.println("----ruzhu---");
        registerService.ruzhu(rid,uName,IdCard,number,day);
    }
    //查询入住记录
    @RequestMapping("findRegister")
    @ResponseBody
    public List<registerTwo> findRegister(){
        List<registerTwo> list=registerService.findRegister();
        return list;
    }

    //删除开房记录
    @RequestMapping("deleteRegisterById")
    public String deleteRegisterById(HttpServletRequest request){
        String reid=request.getParameter("reid");
        registerService.registerService(Integer.parseInt(reid));
        return "kaifang";
    }
}
