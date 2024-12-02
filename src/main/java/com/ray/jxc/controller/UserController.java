package com.ray.jxc.controller;

import com.ray.jxc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-14 14:21
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public Map login(){
        Map map = userService.login();
        return map;
    }

    @RequestMapping("register")
    @ResponseBody
    public Map register(){
        Map map = userService.register();
        return map;
    }

    @RequestMapping("getUserList")
    @ResponseBody
    public Map getUserList(){
        Map map = userService.getUserList();
        return map;
    }

    @RequestMapping("getUserTotal")
    @ResponseBody
    public Map getUserTotal(){
        Map map = userService.getUserTotal();
        return map;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public Map addUser(){
        Map map = userService.addUser();
        return map;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public Map deleteUser(){
        Map map = userService.deleteUser();
        return map;
    }
}
