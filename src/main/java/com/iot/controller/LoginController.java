package com.iot.controller;

import com.iot.bean.User;
import com.iot.sevlet.impl.UserSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserSeviceImpl userSeviceImpl;

    @GetMapping(value={"/","/login"})
    public String  loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(@RequestParam("username") String username,
                       @RequestParam("userpsd") String userpsd,
                       HttpSession session, Model model) {

        if (userSeviceImpl.getUserById(username)==null){
            model.addAttribute("msg","没有此用户，请注册");
            return "login";
        }

        User user1 = userSeviceImpl.getUserById(username);

        if ((username.equals(user1.getUsername()))&&(userpsd.equals(user1.getUserPsd()))) {

            session.setAttribute("loginUser", user1);
            return "redirect:/home";

        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";

        }
    }

    @GetMapping("/main.html")
    public String mainpage(){

        return "redirect:/home";
    }



}
