package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    private Integer goodsId;
    private String goodsName;
    private Integer categoryId;
    private String keyword;
    private Date createTime;
    private Date updateTime;


}
