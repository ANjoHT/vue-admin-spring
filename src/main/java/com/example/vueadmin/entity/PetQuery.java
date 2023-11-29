package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PetQuery {
    @Id
    private Integer petId;
    private String petName;
    private String masterName;
    private Integer petStatus;
    private Integer pageNum;
    private Integer pageSize;
}
