package com.example.vueadmin.service;

import com.example.vueadmin.entity.ShUser;
import com.example.vueadmin.mapper.ShUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShUserService {
    @Autowired
    private ShUserMapper shUserMapper;

    public Map<String,Object> getUserList(Integer pageNumber, Integer pageSize){
        pageNumber = (pageNumber -1) * pageSize;
        List<ShUser> data = shUserMapper.getUserList(pageNumber,pageSize);
        Integer total = shUserMapper.total();
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }

    public Integer addUser(ShUser shUser){
        Integer isSet = shUserMapper.selectSet(shUser);
        if(isSet == 1){
            return 0;
        } else {
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            shUser.setRegTime(formatter.format(date));
            shUser.setCreateTime(formatter.format(date));
            shUser.setUpdateTime(formatter.format(date));
            return shUserMapper.addUser(shUser);
        }
    }

    public Integer deleteUser(Integer id){
       return shUserMapper.delete(id);
    }
}
