package com.ray.jxc.mapper;

import com.ray.jxc.service.TypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author ray
 * @create 2023-04-21 10:28
 */
@Repository
public interface TypeMapper {

    List selectAllType();

    int insertType(@Param("id") String id, @Param("name") String name, @Param("pid") String pid, @Param("date") Date date);

    int deleteType(@Param("id") String id);

    int updateType(@Param("id") String id,@Param("name") String name);

}
