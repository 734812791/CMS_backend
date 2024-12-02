package com.ray.jxc.service;

import com.ray.jxc.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Relation;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ray
 * @create 2023-04-19 11:18
 */
@Service
public class RoleServie {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    HttpServletRequest request;

    //获取根据关键字查询到的角色的集合
    public Map getRoleList(){
        Map map = new HashMap();

        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String account = request.getParameter("account");
        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);

        int start = (page - 1) * size;
        List list = roleMapper.selectRoleList(start, size,account);

        map.put("data",list);
        map.put("code",1);

        return map;
    }

    //获取根据关键字查询到的角色的条数
    public Map getRoleTotal(){
        Map map = new HashMap();

        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String account = request.getParameter("account");
        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);

        int start = 0;
        int total = roleMapper.selectRoleTotal(start, size,account);

        map.put("total",total);
        map.put("code",1);

        return map;
    }

    //新增或修改角色
    public Map addRole(){
        Map map = new HashMap();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String flag = request.getParameter("flag");

        if (id==null){
            id = UUID.randomUUID().toString();
            int i = roleMapper.insertRole(id, name, flag);

            map.put("code",i);
            return map;
        }

        int i = roleMapper.updateRole(id, name, flag);
        map.put("code",i);
        return map;
    }

    //删除用户
    public Map deleteRole(){
        Map map = new HashMap();

        String id = request.getParameter("id");
        int i = roleMapper.deleteRole(id);
        map.put("code",i);

        return map;
    }

    public Map updateRoleMenu(String checkedMenuId,String roleId){
        Map map = new HashMap();

        roleMapper.deleteMenuRoleByRoleId(roleId);

        String[] menuIds = checkedMenuId.split(",");
        for (int i = 0;i < menuIds.length;i++){
            roleMapper.insertMenuRole(UUID.randomUUID().toString(),menuIds[i],roleId);
        }

        map.put("code",1);

        return map;
    }

    public Map getAllRole(){
        Map map = new HashMap();

        List list = roleMapper.selectAllRole();
        map.put("data",list);
        map.put("code",1);

        return map;
    }

    public Map getRoleByUserId(String userId){
        Map map = new HashMap();

        List list = roleMapper.selectRoleByUserId(userId);
        map.put("data",list);
        map.put("code",1);

        return map;
    }

    public Map updateRoleUser(String userId,String roleIds){
        Map map = new HashMap();

        roleMapper.deleteRoleUserByRoleId(userId);

        String[] ids = roleIds.split(",");
        for (int i = 0;i < ids.length;i++){
            roleMapper.insertRoleUser(UUID.randomUUID().toString(),ids[i],userId);
        }

        map.put("code",1);

        return map;
    }




}
