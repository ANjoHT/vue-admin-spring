package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "goods")
@Entity
@Data
public class Goods {
    @Id
    public String goodsName;
    public Integer goodsId;

}
