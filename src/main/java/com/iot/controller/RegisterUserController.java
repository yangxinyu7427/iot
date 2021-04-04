package com.iot.controller;


import com.iot.bean.User;
import com.iot.sevlet.impl.UserSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterUserController {

    /**
     * 注册用户
     */
    @Autowired
    UserSeviceImpl userSeviceImpl;
    @PostMapping("/register")
    public String saveUser(@RequestParam("username") String username,
                         @RequestParam("userpsd") String userpsd,
                         @RequestParam("useremail") String email,
                         Model model){
        if (userSeviceImpl.getUserById(username)!=null){
            model.addAttribute("msg","账号已注册");
            return "register";
        } else {
            User user1 = new User();
            user1.setUsername(username);
            user1.setUserPsd(userpsd);
            user1.setEmail(email);
            userSeviceImpl.saveUser(user1);
            model.addAttribute("msg","账号注册成功");
            return "login";
        }
    }

    @GetMapping("/register")
    public String GetRegisterPage(){
        return "register";
    }
}
