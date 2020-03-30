package com.stq.door.controller;


import com.stq.door.mapper.UserMapper;
import com.stq.door.pojo.Door;
import com.stq.door.pojo.User;
import com.stq.door.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Shang_SRant
 * @since 2020-03-29
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String index(String uid, String upassword, HttpSession session) {
        List<User> users = userService.login(uid, upassword);
        if (users != null) {
            System.out.println(users);
            if (users.get(0).getUlevel().equals("0")) {
                session.setAttribute("ulevel", "普通用户");
            } else{
                session.setAttribute("ulevel","管理员");
            }
            session.setAttribute("uid",users.get(0).getUid());
            session.setAttribute("uname", users.get(0).getUname());
            session.setAttribute("upassword", users.get(0).getUpassword());
            session.setAttribute("uage", users.get(0).getUage());
            session.setAttribute("uphone", users.get(0).getUphone());
            session.setAttribute("uemail", users.get(0).getUemail());
            session.setAttribute("uintroduction", users.get(0).getUintroduction());
            return "redirect:/index";
        } else {
            return "redirect:/login";
        }
    }


    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }


    @RequestMapping("/pwd")
    public String pwd(){
        return "pwd";
    }

    @RequestMapping("/user")
    public String user(Model model){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        model.addAttribute("users",users);
        return "user";
    }

}

