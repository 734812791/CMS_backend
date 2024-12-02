package com.ray.jxc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ray
 * @create 2023-04-19 11:20
 */
@Repository
public interface RoleMapper {

    //查询所有角色
    List selectRoleList(@Param("start") int start,@Param("size") int size,@Param("account") String account);

    //查询总记录条数
    int selectRoleTotal(@Param("start") int start,@Param("size") int size,@Param("account") String account);

    //新增角色
    int insertRole(@Param("id") String id,@Param("name") String name,@Param("flag") String flag);

    //修改角色
    int updateRole(@Param("id") String id,@Param("name") String name,@Param("flag")String flag);

    //删除角色
    int deleteRole(@Param("id") String id);


    int insertMenuRole(@Param("id") String id,@Param("menuId") String menuId,@Param("roleId") String roleId);


    int deleteMenuRoleByRoleId(@Param("roleId") String roleId);


    List selectAllRole();

    List selectRoleByUserId(@Param("userId") String userId);

    int deleteRoleUserByRoleId(@Param("userId") String userId);

    int insertRoleUser(@Param("id") String id,@Param("roleId") String roleId,@Param("userId") String userId);
}
