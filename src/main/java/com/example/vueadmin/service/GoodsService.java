package com.example.vueadmin.service;

import com.example.vueadmin.entity.GoodSearch;
import com.example.vueadmin.entity.Goods;
import com.example.vueadmin.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public Map<String, Object> selectGoodsList(GoodSearch goodSearch) {
        List<Goods> data = goodsMapper.selectGoodsList(goodSearch);
        Integer total = goodsMapper.total(goodSearch);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    public String addGoods(@RequestBody Goods goods) {
        Date date = new Date();
        goods.setCreateTime(date);
        if (goodsMapper.addGoods(goods) == 1) {
            return "创建成功";
        } else {
            return "创建失败";
        }
    }
}
