package com.example.vueadmin.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name = "ware_house")
@Data
public class WareHouse {
    @Id
    private Integer wareHouseId;
    private String wareHouseName;
    private String wareHouseAddress;

}
