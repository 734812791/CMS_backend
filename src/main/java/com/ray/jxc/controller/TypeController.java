package com.ray.jxc.controller;

import com.ray.jxc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-21 10:24
 */
@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @RequestMapping("getTypeList")
    @ResponseBody
    public Map getTypeList(){
        Map map = new HashMap();
        map = typeService.getTypeList();
        return map;
    }

    @RequestMapping("addType")
    @ResponseBody
    public Map addType(String name,String id){
        Map map = new HashMap();
        map = typeService.addType(name,id);
        return map;
    }

    @RequestMapping("deleteType")
    @ResponseBody
    public Map deleteType(String id){
        Map map = new HashMap();
        map = typeService.deleteType(id);
        return map;
    }

    @RequestMapping("updateType")
    @ResponseBody
    public Map updateType(String id,String name){
        Map map = new HashMap();
        map = typeService.updateType(id,name);
        return map;
    }
}
