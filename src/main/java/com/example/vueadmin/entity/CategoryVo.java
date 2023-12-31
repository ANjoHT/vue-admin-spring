package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer sort;
    private List<CategoryVo> subCategories;
}
