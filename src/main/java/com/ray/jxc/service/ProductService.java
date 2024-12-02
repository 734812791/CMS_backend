package com.ray.jxc.service;

import com.ray.jxc.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-25 11:35
 */
@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public Map getProductList(String name,String pageStr,String sizeStr){
        Map map = new HashMap();

        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);
        int start = (page - 1) * size;
        List list = productMapper.selectProductList(name,start,size);
        int total = productMapper.selectProductTotal(name);
        map.put("data",list);
        map.put("total",total);
        map.put("code",1);

        return map;
    }
}
