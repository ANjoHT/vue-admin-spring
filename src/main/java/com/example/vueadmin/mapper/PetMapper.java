package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetMapper {
    @Insert("INSERT INTO `pet` (`pet_image`,`pet_age`,`pet_master`,`pet_name`,`pet_breed`) VALUES (#{petImage} ,#{petAge} ,#{petMaster} ,#{petName} , #{petBreed})")
     Integer addPet(Pet pet);
}
