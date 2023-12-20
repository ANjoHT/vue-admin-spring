package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    public List<Category> all();

    public List<Category> children(Integer id);
    @Insert("INSERT into `category` (parent_id,name,sort,create_time) VALUES (#{parentId},#{name},#{sort},#{createTime})")
    public Integer add(Category category);
}
