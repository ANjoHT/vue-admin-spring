package com.example.vueadmin.controller;

import com.example.vueadmin.entity.WareHouse;
import com.example.vueadmin.mapper.WareHouseMapper;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//仓库管理模块

@RestController
@RequestMapping("/wareHouse")
public class WareHouseController {
    @Autowired
    private WareHouseMapper wareHouseMapper;

    @Autowired
    private WareHouseService wareHouseService;

    /**
     * 通过页数和页码获取仓库分页列表
     *
     * @param pageNum  页数
     * @param pageSize 页骂
     */
    @GetMapping("/getHouse")
    public ServerResponse getHousePage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Map<String, Object> data = wareHouseService.getWareHouse(pageNum, pageSize);
        return ServerResponse.ok(data);
    }

    /**
     * 新增仓库
     *
     * @return data 是否新增成功
     * @params wareHouse 仓库对象
     * 新增一个仓库
     */

    @PostMapping("/addWareHouse")
    public ServerResponse addHouse(@RequestBody WareHouse wareHouse) {
        String data = wareHouseService.addWareHouse(wareHouse);
        return ServerResponse.ok(data);
    }

    @PostMapping("/updateWareHouse")
    public ServerResponse updateWareHouse(@RequestBody WareHouse wareHouse) {
        String data = wareHouseService.updateWareHouse(wareHouse);
        return ServerResponse.ok(data);
    }

    @DeleteMapping("/deleteWareHouse/{id}")
    public ServerResponse deleteWareHouse(@PathVariable Integer id) {
        String data = wareHouseService.deleteWareHouse(id);
        return ServerResponse.ok(data);
    }

    @GetMapping("/selectWareHouse")
    public ServerResponse selectWareHouse(@RequestParam Integer id) {
        WareHouse data = wareHouseService.selectWareHouse(id);
        return ServerResponse.ok(data);
    }

}
