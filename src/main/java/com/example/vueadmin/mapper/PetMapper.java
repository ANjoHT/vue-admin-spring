package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface PetMapper {
    @Insert("INSERT INTO `pet` (`pet_image`,`pet_age`,`pet_master`,`pet_name`,`pet_breed`) VALUES (#{petImage} ,#{petAge} ,#{petMaster} ,#{petName} , #{petBreed})")
    Integer addPet(Pet pet);

    @Select("select * from `pet` limit #{pageNum}, #{pageSize}")
    List<Pet> getPageList(Integer pageNum, Integer pageSize);

    @Select("select count(*) from `pet`")
    Integer total();

    @Update("update `pet` set pet_status = #{petStatus} where pet_id = #{petId}")
    Integer update(Integer petId, int petStatus);
}
