package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="user")
@Entity
@Data

public class User {
    @jakarta.persistence.Id
    @Id
    private Integer id;
    private String username;
    private int age;
    private String password;
    private String sex;
}
