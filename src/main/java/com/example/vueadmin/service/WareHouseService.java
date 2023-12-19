package com.example.vueadmin.service;

import com.example.vueadmin.entity.WareHouse;
import com.example.vueadmin.mapper.WareHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class WareHouseService {
    @Autowired
    private WareHouseMapper wareHouseMapper;

    // 分页业务层，根据pageNum和pageSize查询仓库分页列表
    public Map<String, Object> getWareHouse(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<WareHouse> data = wareHouseMapper.getWareHouse(pageNum, pageSize);
        Integer total = wareHouseMapper.getTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }

    //新增仓库业务逻辑
    public String addWareHouse(@RequestBody WareHouse wareHouse) {
        WareHouse data = wareHouseMapper.selectWareHouse(wareHouse.getWareHouseId());
        if (data.getWareHouseId() != 0) {
            return "仓库已存在";
        } else {
            wareHouseMapper.addWareHouse(wareHouse);
            return "新增成功";
        }
    }

    //更新仓库信息
    public String updateWareHouse(@RequestBody WareHouse wareHouse) {
        WareHouse data = wareHouseMapper.selectWareHouse(wareHouse.getWareHouseId());
        if (data.getWareHouseId() != 0) {
            wareHouseMapper.updateWareHouse(wareHouse);
            return "修改成功";
        } else {
            return "仓库不存在";
        }
    }

    //删除仓库
    public String deleteWareHouse(@PathVariable Integer id) {
        if (wareHouseMapper.selectWareHouse(id).getWareHouseId() != 0) {
            wareHouseMapper.deleteWareHouse(id);
            return "删除成功";
        } else {
            return "仓库不存在";
        }
    }

    //查询仓库详细信息
    public WareHouse selectWareHouse(@RequestParam Integer id) {
        return wareHouseMapper.selectWareHouse(id);
    }
}
