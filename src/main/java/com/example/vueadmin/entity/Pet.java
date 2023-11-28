package com.example.vueadmin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pet")
public class Pet {
    @Id
    private Integer petId;
    private String petName;
    private String petMaster;
    private Integer petAge;
    private String petBreed;
    private String petImage;

}
