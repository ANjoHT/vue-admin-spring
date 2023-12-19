package com.example.vueadmin.mapper;

import com.example.vueadmin.entity.GoodSearch;
import com.example.vueadmin.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> selectGoodsList(GoodSearch goodSearch);

    Integer total(GoodSearch goodSearch);

    @Insert("INSERT into `goods` (goods_id,goods_name,category_id,keyword,create_time) VALUES (#{goodsId},#{goodsName},#{categoryId},#{keyword},#{createTime})")
    Integer addGoods(Goods goods);
}
