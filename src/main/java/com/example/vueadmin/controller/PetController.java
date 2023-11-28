package com.example.vueadmin.controller;

import com.example.vueadmin.entity.Pet;
import com.example.vueadmin.mapper.PetMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {
    private PetMapper petMapper;
    @PostMapping("/addPet")
    public Integer addPet(Pet pet) {
        return petMapper.addPet(pet);
    }
}
