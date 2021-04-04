package com.iot.controller;


import com.iot.bean.Equipment;
import com.iot.bean.User;
import com.iot.sevlet.impl.UserSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserSeviceImpl userSeviceImpl;


    @GetMapping("/home")
    public String GetHomePage(HttpSession session, Model model){

        User loginUser = (User)session.getAttribute("loginUser");
        String Username=loginUser.getUsername();
        List<Equipment> equipmentList= userSeviceImpl.getEquipmentByUsername(Username);
        if(equipmentList.size()==0){
            model.addAttribute("msg","尚未绑定设备");
            return "productAdd";
        }
        else{
            model.addAttribute("equipmentList",equipmentList);
            model.addAttribute("loginUser",loginUser);
            return "home";
        }
    }


    @GetMapping("/bind")
    public String BindEquipment(HttpSession session, Model model, @RequestParam("EquipmentUid") String EquipmentUid){
        User loginUser = (User)session.getAttribute("loginUser");
        String Username=loginUser.getUsername();
        if(userSeviceImpl.getEquipmentByUid(EquipmentUid)!=null){
            model.addAttribute("msg","已绑定的设备");
            return "productAdd";
        }
        else{
            userSeviceImpl.saveEquipment(Username,EquipmentUid);
            return "forward:/home";
        }
    }

    @ResponseBody
    @GetMapping("/UpdatePsd")
    public User UpdatePsd(HttpSession session, Model model, @RequestParam("UserPsd") String UserPsd){
        User loginUser = (User)session.getAttribute("loginUser");
        String Username=loginUser.getUsername();
        loginUser.setUserPsd(UserPsd);
        userSeviceImpl.updatePsd(loginUser);
        return userSeviceImpl.getUserById(Username);
    }

//@GetMapping("test")
//public String test(Model model,HttpSession session){
//    User loginUser = (User)session.getAttribute("loginUser");
//    String Username=loginUser.getUsername();
//    List<Equipment> equipmentList= userSeviceImpl.getEquipmentByUsername(Username);
//    if(equipmentList.size()==0){
//        model.addAttribute("msg","尚未绑定设备");
//        return "productAdd";
//    }
//    else{
//        model.addAttribute("equipmentList",equipmentList);
//        model.addAttribute("loginUser",loginUser);
//        return "productList";
//    }
//}


    @GetMapping("/productList")
    public String product(Model model,HttpSession session){
        User loginUser = (User)session.getAttribute("loginUser");
        String Username=loginUser.getUsername();
        List<Equipment> equipmentList= userSeviceImpl.getEquipmentByUsername(Username);
        model.addAttribute("equipmentList",equipmentList);
        return "productList";
    }

    @GetMapping("/productFunction")
    public String productFunction(Model model,HttpSession session,@RequestParam("id") Integer equipmentUrl){
        User loginUser = (User)session.getAttribute("loginUser");
        String Username=loginUser.getUsername();
        return "productFunction";

    }

}
