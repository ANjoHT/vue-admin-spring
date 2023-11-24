package com.example.vueadmin.mapper;
import com.example.vueadmin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();
    @Insert("INSERT into `user` (username,password,age,sex) VALUES (#{username},#{password},#{age},#{sex})")
    int insert(User user);

//    @Update("UPDATE `user`set username = #{username},password = #{password},age = #{age}, sex = #{sex} where id = #{id}")
    int update(User user);

    @Delete("DELETE from `user` where id = #{id}")
    int delete(@Param("id") Integer id);

    @Select("select * from user limit #{pageNum}, #{pageSize}")
    List<User> findPage(Integer pageNum,Integer pageSize);

    @Select("select count(*) from user")
    Integer total();
}
