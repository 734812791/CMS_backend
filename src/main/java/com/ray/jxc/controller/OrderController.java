package com.ray.jxc.controller;

import com.ray.jxc.pojo.Order;
import com.ray.jxc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-25 16:35
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("addOrder")
    @ResponseBody
    public Map addOrder(Order order){
        Map map = new HashMap();
        map = orderService.addOrder(order);
        return map;
    }

    @RequestMapping("getOrderList")
    @ResponseBody
    public Map getOrderList(String userId,String typeName,String page,String size,String orderType){
        Map map = new HashMap();
        map = orderService.getOrderList(userId,typeName,page,size,orderType);
        return map;
    }

    @RequestMapping("getAllOrderList")
    @ResponseBody
    public Map getAllOrderList(String orderType,String typeName,String page,String size){
        Map map = new HashMap();
        map = orderService.getAllOrderList(orderType,typeName,page,size);
        return map;
    }

    @RequestMapping("deleteOrder")
    @ResponseBody
    public Map deleteOrder(String id){
        Map map = new HashMap();
        map = orderService.deleteOrder(id);
        return map;
    }

    @RequestMapping("fixOrder")
    @ResponseBody
    public Map fixOrder(String id,String price,String number,String status){
        Map map = new HashMap();
        map = orderService.fixOrder(id,price,number,status);
        return map;
    }

    @RequestMapping("rejectOrder")
    @ResponseBody
    public Map rejectOrder(String id,String status,String reason){
        Map map = new HashMap();
        map = orderService.rejectOrder(id,status,reason);
        return map;
    }

    @RequestMapping("getOrderById")
    @ResponseBody
    public Map getOrderById(String id){
        Map map = new HashMap();
        map = orderService.getOrderById(id);
        return map;
    }

    @RequestMapping("passOrder")
    @ResponseBody
    public Map passOrder(String id,String number,String orderType,String typeId){
        Map map = new HashMap();
        map = orderService.passOrder(id,number,orderType,typeId);
        return map;
    }

}
