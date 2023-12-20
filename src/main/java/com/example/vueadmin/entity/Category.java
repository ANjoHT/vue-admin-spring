package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Table(name = "category")
@Entity
public class Category {
    @Id
    private Integer id;
    private Integer parentId;
    private String name;
    private String sort;
    private Date createTime;
    private Date updateTime;
    private Object children;
}
