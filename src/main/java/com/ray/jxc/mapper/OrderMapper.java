package com.ray.jxc.mapper;

import com.ray.jxc.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ray
 * @create 2023-04-25 16:42
 */
@Repository
public interface OrderMapper {

    int insertOrder(Order order);

    List selectOrderList(@Param("userId") String userId, @Param("typeName") String typeName,@Param("start") int start,@Param("size") int size,@Param("orderType")String orderType);

    List selectAllOrderList(@Param("orderType") String orderType, @Param("typeName") String typeName,@Param("start") int start,@Param("size") int size);

    int selectOrderTotal(@Param("userId") String userId, @Param("typeName") String typeName,@Param("orderType")String orderType);

    int selectAllOrderTotal(@Param("orderType") String orderType, @Param("typeName") String typeName);

    int deleteOrderById(@Param("id") String id);

    int updateOrderById(@Param("id") String id,@Param("price")int price,@Param("number")int number,@Param("status") int status);

    int updateOrderStatusById(@Param("id") String id,@Param("status") int status,@Param("reason") String reason);

    Order getOrderById(@Param("id") String id);

    Map getTotalByOrderId(@Param("id") String id);

    int updateOrderReasonById(@Param("id") String id,@Param("reason") String reason);
}
