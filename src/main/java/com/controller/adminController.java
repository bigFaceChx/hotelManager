package com.controller;

import com.pojo.administrator;
import com.Utils.yzmUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class adminController {
    @Autowired
    private com.service.adminService adminService;
    /*登录*/
    @RequestMapping("login")
    public String login(HttpServletRequest request){

        String uName=request.getParameter("uName");
        String uPassword=request.getParameter("uPassword");
        String yzm=request.getParameter("yzm");
        HttpSession session = request.getSession();
        //获取session中存储的验证码
        String yzmTwo=(String)session.getAttribute("yzm");
        //判断验证码是否正确
        if (yzm.equalsIgnoreCase(yzmTwo)){
            //判断用户名或密码是否存在
            boolean flag=adminService.login(uName,uPassword);
            if (flag){
                //如果用户名存在,跳转后台页面，并加入session
                administrator administrator = new administrator();
                administrator.setUser(uName);
                administrator.setPassword(uPassword);
                session.setAttribute("admin",administrator);
                return "index";
            }else {
                //如果用户名不存在，返回错误信息，并跳转登录页面
                request.setAttribute("msg","用户名或密码错误！");
                return "login";
            }
        }else {
            //如果验证码错误，返回错误信息，并跳转登录页面
            request.setAttribute("msg","验证码错误！");
            return "login";
        }
    }
    /*验证码*/
    @RequestMapping("yzm")
    public void  yzm(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("image/jpeg");
        yzmUtil yzm = new yzmUtil();
        BufferedImage image = yzm.getImage();
        request.getSession().setAttribute("yzm",yzm.getText());
        System.out.println(yzm.getText());
        try {
            yzmUtil.output(image,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*退出登录*/
    @RequestMapping("exitLogin")
    public String exitLogin(HttpSession session){
        session.setAttribute("admin",null);
        return "login";
    }
}
