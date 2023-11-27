package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();


    //    @Update("UPDATE `user`set username = #{username},password = #{password},age = #{age}, sex = #{sex} where id = #{id}")
    int update(User user);

    @Delete("DELETE from `user` where id = #{id}")
    int delete(@Param("id") Integer id);

    @Select("select * from user limit #{pageNum}, #{pageSize}")
    List<User> findPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from user")
    Integer total();

    @Select("select * from user where username=#{username} and password=#{password}")
    List<User> login(String username, String password);

    @Insert("INSERT into `user` (uuid,password,username,gender,age,phone,eMail,avatar) VALUES (#{uuid},#{password},#{username},#{gender},#{age},#{phone},#{eMail},#{avatar})")
    int insert (User user);
    @Select("SELECT * from user where username = #{username}")
    List<User> select(User user);
}
