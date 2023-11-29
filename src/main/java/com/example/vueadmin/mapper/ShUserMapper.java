package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.ShUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShUserMapper {

    @Select("SELECT * FROM `sh_user` limit #{pageNumber},#{pageSize}")
    List<ShUser> getUserList(Integer pageNumber, Integer pageSize);

    @Select("SELECT COUNT(*) FROM `sh_user`")
    Integer total();

    @Select("SELECT COUNT(*) FROM `sh_user` where username = #{username}")
    Integer selectSet(ShUser shUser);

    @Insert("INSERT INTO `sh_user` (`username`,`password`,`salt`,`email`,`mobile`,`level`,`money`,`gender`,`qq`,`is_active`,`reg_time`,`create_time`,`update_time`) values (#{username},#{password},#{salt},#{email},#{mobile},#{level},#{money},#{gender},#{qq},#{isActive},#{regTime},#{createTime},#{updateTime})")
    Integer addUser(ShUser shUser);

    @Delete("DELETE from `sh_user` where id = #{id}")
    Integer delete(Integer id);
}
