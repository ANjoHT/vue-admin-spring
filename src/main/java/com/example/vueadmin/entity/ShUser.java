package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "sh_user")
public class ShUser {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Boolean level;
    private Integer money;
    private Boolean gender;
    private Integer qq;
    private Boolean isActive;
    private String regTime;
    private String createTime;
    private String updateTime;

}
