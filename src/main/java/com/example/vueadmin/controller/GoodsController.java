package com.example.vueadmin.controller;

import com.example.vueadmin.entity.GoodSearch;
import com.example.vueadmin.entity.Goods;
import com.example.vueadmin.mapper.GoodsMapper;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsMapper goodsMapper;

    @PostMapping("/selectGoodsList")
    public ServerResponse selectGoodsList(@RequestBody GoodSearch goodSearch) {
        Map<String, Object> data = goodsService.selectGoodsList(goodSearch);
        return ServerResponse.ok(data);
    }

    @PostMapping("/addGoods")
    public ServerResponse addGoods(@RequestBody Goods goods) {
        return ServerResponse.ok(goodsService.addGoods(goods));
    }

}
