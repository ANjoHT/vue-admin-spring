package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class GoodSearch {
    @Id
    private Integer goodsId;
    private String goodsName;
    private Integer goodsCount;
    private Integer categoryId;
    private String keyword;
    private Date createTime;
    private Date updateTime;
    private String goodsStatus;
    private String warehousingType;
    private String outboundType;
    private Integer wareHouseId;
    private Integer pageNum;
    private Integer pageSize;
}
