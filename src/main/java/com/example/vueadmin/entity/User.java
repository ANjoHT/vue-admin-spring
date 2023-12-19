package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Table(name = "user")
@Entity
@Data
public class User {
    @jakarta.persistence.Id
    @Id
    private BigInteger id;
    private String username;
    private String password;
    private String phone;

}
