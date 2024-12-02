package com.ray.jxc.service;

import com.ray.jxc.mapper.OrderMapper;
import com.ray.jxc.mapper.ProductMapper;
import com.ray.jxc.mapper.TypeMapper;
import com.ray.jxc.pojo.Order;
import com.ray.jxc.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ray
 * @create 2023-04-25 16:42
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    HttpServletRequest request;

    public Map addOrder(Order order){
        Map map = new HashMap();
        order.setId(UUID.randomUUID().toString());

//        System.out.println(order.getTypeId());
//        if("".equals(order.getTypeId())||order.getTypeId()==null){
//            String typeId = UUID.randomUUID().toString();
//            order.setTypeId(typeId);
//
//            String productId = UUID.randomUUID().toString();
//            productMapper.insertProduct(productId,typeId,order.getNumber());
//
//            String typeName = request.getParameter("name");
//            typeMapper.insertType(typeId,typeName,null,new Date());
//        }
//        System.out.println(order.getTypeId());

        order.setCreateDate(new Date());
        int i = orderMapper.insertOrder(order);
        map.put("code",i);
        return map;
    }

    public Map getOrderList(String userId,String typeName,String pageStr,String sizeStr,String orderType){
        Map map = new HashMap();
        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);
        int start = (page - 1) * size;
        List list = orderMapper.selectOrderList(userId, typeName,start,size,orderType);
        int total = orderMapper.selectOrderTotal(userId, typeName,orderType);
        map.put("data",list);
        map.put("total",total);
        map.put("code",1);
        return map;
    }

    public Map getAllOrderList(String orderType,String typeName,String pageStr,String sizeStr){
        Map map = new HashMap();
        int page = Integer.parseInt(pageStr);
        int size = Integer.parseInt(sizeStr);

        int start = (page - 1) * size;
        List list = orderMapper.selectAllOrderList(orderType, typeName,start,size);
        int total = orderMapper.selectAllOrderTotal(orderType, typeName);
        map.put("data",list);
        map.put("total",total);
        map.put("code",1);
        return map;
    }

    public Map deleteOrder(String id){
        Map map = new HashMap();
        int i = orderMapper.deleteOrderById(id);
        map.put("code",i);
        return map;
    }

    public Map fixOrder(String id,String priceStr,String numberStr,String statusStr){
        Map map = new HashMap();

        int price = Integer.parseInt(priceStr);
        int number = Integer.parseInt(numberStr);
        int status = Integer.parseInt(statusStr);
        int i = orderMapper.updateOrderById(id,price,number,status);
        map.put("code",i);
        return map;
    }

    public Map rejectOrder(String id,String statusStr,String reason){
        Map map = new HashMap();
        int status = Integer.parseInt(statusStr);
        int i = orderMapper.updateOrderStatusById(id,status,reason);
        map.put("code",i);
        return map;
    }

    public Map getOrderById(String id){
        Map map = new HashMap();
        Order order = orderMapper.getOrderById(id);
        map.put("data",order);
        map.put("code",1);
        return map;
    }

    public Map passOrder(String id,String numberStr,String orderType,String typeId){
        Map map = new HashMap();
        int number = Integer.parseInt(numberStr);
        int i=0;

        String reason;
        Map resultMap = orderMapper.getTotalByOrderId(id);

        //1为入库单
        if("購入オーダー".equals(orderType)){
            if(resultMap==null){
                i = productMapper.insertProduct(UUID.randomUUID().toString(), typeId, number);
                i = orderMapper.updateOrderStatusById(id,3, "");
            }else {
                String productId = (String) resultMap.get("id_");
                int total = (int)resultMap.get("total_");
                i = productMapper.updateProductById(productId,total+number);
                i = orderMapper.updateOrderStatusById(id,3, "");
            }


            map.put("code",i);
            return map;
        }


        if (resultMap==null){

            reason = "库存不足，请先采购";
            i = orderMapper.updateOrderStatusById(id,2, reason);
            map.put("code",i);

        }else if((int)resultMap.get("total_")<number){

            reason = "库存不足，请先采购";
            i = orderMapper.updateOrderStatusById(id,2, reason);
            map.put("code",i);

        }else if((int)resultMap.get("total_")==number){
            System.out.println(resultMap.get("id_"));
            productMapper.deleteProductById((String) resultMap.get("id_"));
            i = orderMapper.updateOrderStatusById(id,3, "");
            map.put("code",i);

        }else if((int)resultMap.get("total_")>number){

            String productId = (String) resultMap.get("id_");
            int total = (int)resultMap.get("total_");
            productMapper.updateProductById(productId,total-number);
            i = orderMapper.updateOrderStatusById(id,3, "");

        }

        map.put("data",resultMap);
        map.put("code",i);
        return map;
    }
}
