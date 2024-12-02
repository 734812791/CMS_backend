package com.ray.jxc.service;

import com.ray.jxc.mapper.IndexMapper;
import com.ray.jxc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ray
 * @create 2023-04-15 9:24
 */
@Service
public class IndexService {

    @Autowired
    IndexMapper indexMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpServletRequest request;

    //获取全部菜单
    public Map getAllMenu(){
        Map map = new HashMap();

        List list = indexMapper.selectAllMenu();

        map.put("data",list);
        map.put("code",1);
        return map;
    }

    //根据角色获取菜单
    public Map menu(){

        Map map = new HashMap();

        String roleId = request.getParameter("roleId");
        String id = request.getParameter("id");

        if (roleId == null || "".equals(roleId)){
            roleId = id;
        }

        if(roleId == null||"".equals(roleId)){
            map.put("data",null);
            map.put("code",1);
            return map;
        }

        if(roleId.length()==1){
            if(roleId == null || roleId == ""){
                roleId = "1";
            }
            List list = indexMapper.selectMenu(roleId);

            map.put("data",list);
            map.put("code",1);
            return map;
        }

        String[] roleIds = roleId.split(",");
        for(String r : roleIds){

        }
        List list = indexMapper.selectMenuByIds(roleIds);


        map.put("data",list);
        map.put("code",1);
        return map;
    }

    public Map addMenu(){
        Map map = new HashMap();

        String pid = request.getParameter("id");

        String id = UUID.randomUUID().toString();
        String text = request.getParameter("text");
        String url = request.getParameter("url");
        String icon = request.getParameter("icon");
        String order = request.getParameter("order");

        String isAdd = request.getParameter("isAdd");

        if ("false".equals(isAdd)){
            id = pid;
            int i = indexMapper.updateMenu(id, text, url, icon, order);
            map.put("code",i);
            return map;
        }



        if ("".equals(pid) || pid == null){
            pid = null;
        }
        if ("".equals(order) || order == null){
            order = null;
        }


        int i = indexMapper.insertMenu(id,text,url,icon,order,pid);
        map.put("code",i);
        return map;
    }

    public Map deleteMenu(){

        String id = request.getParameter("id");

        int i = indexMapper.deleteMenu(id);
        Map map = new HashMap();
        map.put("code",i);
        return map;
    }
}
