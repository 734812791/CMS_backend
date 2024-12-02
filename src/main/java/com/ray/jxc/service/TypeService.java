package com.ray.jxc.service;

import com.ray.jxc.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ray
 * @create 2023-04-21 10:25
 */
@Service
public class TypeService {

    @Autowired
    TypeMapper typeMapper;

    public Map getTypeList(){
        Map map = new HashMap();

        List list = typeMapper.selectAllType();
        map.put("data",list);
        map.put("code",1);
        return map;
    }

    public Map addType(String name,String pid){
        Map map = new HashMap();

        if("".equals(pid)){
            pid = null;
        }

        String id = UUID.randomUUID().toString();
        Date date = new Date();
        int i = typeMapper.insertType(id,name,pid,date);

        map.put("code",i);
        return map;
    }


    public Map deleteType(String id){
        Map map = new HashMap();

        int i = typeMapper.deleteType(id);

        map.put("code",i);
        return map;
    }

    public Map updateType(String id,String name){
        Map map = new HashMap();

        int i = typeMapper.updateType(id,name);

        map.put("code",i);
        return map;
    }
}
