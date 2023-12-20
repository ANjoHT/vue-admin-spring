package com.example.vueadmin.service;

import com.example.vueadmin.entity.Category;
import com.example.vueadmin.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> query() {
        List<Category> father = categoryMapper.all();
//        List<Category> children = categoryMapper.children(2);
        for (int i = 0; i < father.size(); i++) {
            Integer id = father.get(i).getId();
            System.out.println(id + "id");
            List<Category> data = categoryMapper.children(id);
            if(data.size() < 1){
                data = null;
            }
            father.get(i).setChildren(data);
        }

        return father;
    }

    ;

    public String add(@RequestBody Category category) {
        Date date = new Date();
        category.setCreateTime(date);
        if (categoryMapper.add(category) == 1) {
            return "新增成功";
        } else {
            return "新增失败";
        }
    }
}
