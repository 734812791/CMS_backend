package com.ray.jxc.controller;

import com.ray.jxc.service.RoleServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-19 11:08
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleServie roleServie;

    @RequestMapping("getRoleList")
    @ResponseBody
    public Map getRoleList(){
        Map map = roleServie.getRoleList();
        return map;
    }

    @RequestMapping("getRoleTotal")
    @ResponseBody
    public Map getRoleTotal(){
        Map map = roleServie.getRoleTotal();
        return map;
    }

    @RequestMapping("addRole")
    @ResponseBody
    public Map addRole(){
        Map map = roleServie.addRole();
        return map;
    }

    @RequestMapping("deleteRole")
    @ResponseBody
    public Map deleteRole(){
        Map map = roleServie.deleteRole();
        return map;
    }

    @RequestMapping("updateRoleMenu")
    @ResponseBody
    public Map updateRoleMenu(String checkedMenuId,String roleId){
        Map map = roleServie.updateRoleMenu(checkedMenuId,roleId);
        return map;
    }

    @RequestMapping("getAllRole")
    @ResponseBody
    public Map getAllRole(){
        Map map = roleServie.getAllRole();
        return map;
    }

    @RequestMapping("getRoleByUserId")
    @ResponseBody
    public Map getRoleByUserId(String userId){
        Map map = roleServie.getRoleByUserId(userId);
        return map;
    }

    @RequestMapping("updateRoleUser")
    @ResponseBody
    public Map updateRoleUser(String userId,String roleIds){
        Map map = roleServie.updateRoleUser(userId,roleIds);
        return map;
    }
}
