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
    private String uuid;
    private String username;
    private String gender;
    private String password;
    private Integer age;
    private String phone;
    private String eMail;
    private String avatar;
}
