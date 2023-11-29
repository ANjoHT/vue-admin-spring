package com.example.vueadmin.service;

import com.example.vueadmin.entity.Pet;
import com.example.vueadmin.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PetService {
    @Autowired
    private PetMapper petMapper;

    public Map<String, Object> getPetList(@RequestParam Integer pageNum, Integer pageSize){
        pageNum = (pageNum - 1) * pageSize;
        List<Pet> data = petMapper.getPageList(pageNum,pageSize);
        System.out.println(data);
        Integer total = petMapper.total();
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    public Integer updatePetStatus( Integer petId,Integer petStatus){
       return petMapper.update(petId,petStatus);
    }
}
