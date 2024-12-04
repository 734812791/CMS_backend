package com.ray.jxc.service;

import com.ray.jxc.mapper.RoleMapper;
import com.ray.jxc.mapper.UserMapper;
import com.ray.jxc.pojo.User;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author ray
 * @create 2023-04-14 14:21
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    HttpServletRequest request;

    public Map login(){
        HashMap map = new HashMap<>();

        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (account==null||account==""){
            map.put("code",0);
            map.put("msg","账号为空");
            return map;
        }

        if (password==null||password==""){
            map.put("code",0);
            map.put("msg","密码为空");
            return map;
        }

        User user = userMapper.selectUserByAccount(account);
        if (user == null){
            map.put("code",0);
            map.put("msg","账号不存在");
            return map;
        }

        if (!password.equals(user.getPassword())){
            map.put("code",0);
            map.put("msg","密码错误");
            return map;
        }

        map.put("user",user);
        map.put("code",1);
        map.put("msg","登录成功");

        List roleId = userMapper.selectUserRole(account);
        map.put("roleId",roleId);

        return map;
    }

    //根据id是否存在修改或新增用户
    public Map register(){
        Map map = new HashMap();

        String id = request.getParameter("id");
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String birthdayStr = request.getParameter("birthday");

        if(account != null && !("".equals(account))){

            if (userMapper.selectUserByAccount(account) != null){
                map.put("code",0);
                map.put("msg","アカウントは既に存在します");
                return map;
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday=null;
        try {
            if (birthdayStr != null)
                birthday = sdf.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        id = UUID.randomUUID().toString();
        int i = userMapper.insertUser(id,account,password,name,birthday);

        //默认赋予新用户销售和采购的角色
        int i2 = roleMapper.insertRoleUser(UUID.randomUUID().toString(),"2",id);
        int i3 = roleMapper.insertRoleUser(UUID.randomUUID().toString(),"3",id);

        map.put("code",i);
        map.put("msg","登録完了");

        return map;
    }

    //获取根据关键字查询到的用户的集合
    public Map getUserList(){
        Map map = new HashMap();

        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String account = request.getParameter("account");

        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);

        int start = (page - 1) * size;
        List list = userMapper.selectUserList(start, size,account);

        map.put("data",list);
        map.put("code",1);

        return map;
    }

    //获取根据关键字查询到的用户的条数
    public Map getUserTotal(){
        Map map = new HashMap();

        String pageStr = request.getParameter("page");
        String sizeStr = request.getParameter("size");
        String account = request.getParameter("account");

        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);

        int start = 0;
        int total = userMapper.selectUserTotal(start, size,account);

        map.put("total",total);
        map.put("code",1);

        return map;
    }

    //根据id是否存在修改或新增用户
    public Map addUser(){
        Map map = new HashMap();

        String id = request.getParameter("id");
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String birthdayStr = request.getParameter("birthday");
        String title = request.getParameter("title");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday=null;
        try {
            if (birthdayStr != null)
            birthday = sdf.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if ("添加用户".equals(title)){
            if (userMapper.selectUserByAccount(account) == null){
                id = UUID.randomUUID().toString();
                int i = userMapper.insertUser(id,account,password,name,birthday);

                map.put("code",i);
                map.put("msg","添加成功");
                return map;
            }else {
                map.put("code",0);
                map.put("msg","账户已存在");
                return map;
            }
        }



        if ("编辑用户".equals(title)){
            int i = userMapper.updateUser(id, account,password, name,birthday);
            map.put("code",i);
            map.put("msg","修改成功");
            return map;
        }


        return map;
    }

    public Map deleteUser(){
        Map map = new HashMap();

        String id = request.getParameter("id");
        int i = userMapper.deleteUser(id);
        map.put("code",i);

        return map;
    }
}
