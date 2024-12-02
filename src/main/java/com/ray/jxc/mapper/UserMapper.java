package com.ray.jxc.mapper;

import com.ray.jxc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author ray
 * @create 2023-04-14 14:21
 */
@Repository
public interface UserMapper {

    //根据关键字查询所有用户
    List selectUserList(@Param("start") int start, @Param("size") int size, @Param("account") String account);

    //查询到的总记录条数
    int selectUserTotal(@Param("start") int start,@Param("size") int size,@Param("account") String account);

    //根据账户名查询用户
    User selectUserByAccount(@Param("account") String account);

    //根据账户名查询用户角色
    List selectUserRole(@Param("account") String account);

    //新增用户
    int insertUser(@Param("id") String id,@Param("account")String account,@Param("password")String password,@Param("name") String name,@Param("birthday") Date birthday);

    //根据id修改用户信息
    int updateUser(@Param("id") String id,@Param("account") String account,@Param("password")String password,@Param("name") String name,@Param("birthday") Date birthday);

    //根据id删除用户
    int deleteUser(@Param("id")String id);
}
