package com.ray.jxc.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ray
 * @create 2023-04-15 9:25
 */
@Repository
public interface IndexMapper {

    //根据角色id查询菜单
    List selectMenu(@Param("roleId") String roleId);

    //根据多个角色id查询菜单
    List selectMenuByIds(@Param("roleIds")String[] roleIds);

    //添加下级
    int insertMenu(@Param("id") String id, @Param("text") String text,@Param("url") String url,@Param("icon") String icon,@Param("order") String order,@Param("pid") String pid);

    //删除指定id元素
    int deleteMenu(@Param("id") String id);

    //根据id修改元素
    int updateMenu(@Param("id") String id,@Param("text") String text,@Param("url") String url,@Param("icon") String icon,@Param("order") String order);

    //查询菜单表数据
    List selectAllMenu();
}
