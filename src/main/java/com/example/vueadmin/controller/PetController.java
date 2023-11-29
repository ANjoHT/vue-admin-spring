package com.example.vueadmin.controller;

import com.example.vueadmin.entity.Pet;
import com.example.vueadmin.mapper.PetMapper;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetService petService;

    @PostMapping("/addPet")
    public ServerResponse addPet(Pet pet) {
        petMapper.addPet(pet);
        return ServerResponse.ok("成功");
    }

    @GetMapping("/getPetList")
    public ServerResponse getPetList(Integer pageNum, Integer pageSize) {
        Map<String, Object> res = petService.getPetList(pageNum, pageSize);
        return ServerResponse.ok(res);
    }

    @PostMapping("/updateStatus")
    public ServerResponse updateStatus(@RequestBody Pet pet) {
        Integer res = petService.updatePetStatus(pet.getPetId(), pet.getPetStatus());
        if (res == 1) {
            return ServerResponse.ok("修改成功");
        } else {
            return ServerResponse.badRequest("修改失败");
        }
    }
}
