package com.ray.jxc.controller;

import com.ray.jxc.config.RedisUtil;
import com.ray.jxc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-15 9:21
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    IndexService indexService;

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("getAllMenu")
    @ResponseBody
    public Map getAllMenu(){
        Map map = indexService.getAllMenu();
        return map;
    }

    @RequestMapping("menu")
    @ResponseBody
    public Map menu(String roleId){
        Map map = new HashMap();

        //redis相关，打开这两条，以开启redis，1
//        boolean flag = redisUtil.hasKey(roleId);
        boolean flag = false;
        if(flag){
            Object o = redisUtil.get(roleId);
            map.put("data",o);
            map.put("code",1);
        }else {
            System.out.println(roleId+"获取菜单");
            map = indexService.menu();

            //redis相关，打开这两条，以开启redis，2
//            redisUtil.set(roleId,map.get("data"),1100);
        }

        return map;
    }

    @RequestMapping("addMenu")
    @ResponseBody
    public Map addMenu(){
        Map map = indexService.addMenu();
        return map;
    }

    @RequestMapping("deleteMenu")
    @ResponseBody
    public Map deleteMenu(){
        Map map = indexService.deleteMenu();
        return map;
    }
}
