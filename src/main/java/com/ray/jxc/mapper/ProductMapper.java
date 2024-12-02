package com.ray.jxc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ray
 * @create 2023-04-25 11:36
 */
@Repository
public interface ProductMapper {

    List selectProductList(@Param("key") String key,@Param("start") int start,@Param("size") int size);

    int selectProductTotal(@Param("key") String key);

    int deleteProductById(@Param("id") String id);

    int deleteProductByTypeId(@Param("typeId") String typeId);

    int updateProductById(@Param("id") String id,@Param("total") int total);

    int insertProduct(@Param("id") String id,@Param("typeId") String typeId,@Param("total") int total);


}
