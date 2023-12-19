package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.WareHouse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WareHouseMapper {
    @Select("select * from ware_house limit #{pageNum}, #{pageSize}")
    public List<WareHouse> getWareHouse(Integer pageNum, Integer pageSize);

    @Select("select count(*) from ware_house")
    public Integer getTotal();

    @Insert("INSERT into `ware_House` (ware_house_id,ware_house_name,ware_house_address) VALUES (#{wareHouseId},#{wareHouseName},#{wareHouseAddress})")
    public Integer addWareHouse(WareHouse wareHouse);

    @Select("select * from ware_house where ware_house_id = #{wareHouseId}")
    public WareHouse selectWareHouse(Integer wareHouseId);

    @Update("UPDATE `ware_house`set ware_house_name = #{wareHouseName},ware_house_address = #{wareHouseAddress} where ware_house_id = #{wareHouseId}")
    public Integer updateWareHouse(WareHouse wareHouse);

    @Delete("DELETE from `ware_house` where ware_house_id = #{id}")
    public Integer deleteWareHouse(Integer id);
}
