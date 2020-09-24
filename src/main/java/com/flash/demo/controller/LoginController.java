package com.flash.demo.controller;


import com.flash.demo.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpSession session){

        //业务
        if (!StringUtils.isEmpty(username) && "".equals(password)) {

            session.setAttribute("loginUser",username);

            //实际上并没有main这个HTML页面，在MyMvcConfig中映射到dashboard
            return "redirect:/main.html";
        }else {
            //登录失败
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginUser");
        return "/index.html";
    }
}
