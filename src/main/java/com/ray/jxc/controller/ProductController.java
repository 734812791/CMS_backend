package com.ray.jxc.controller;

import com.ray.jxc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-25 11:33
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("getProductList")
    @ResponseBody
    public Map getProductList(String name,String page,String size){
        Map map = new HashMap();
        map = productService.getProductList(name,page,size);
        return map;
    }
}
