package com.example.vueadmin.service;

import com.example.vueadmin.entity.User;
import com.example.vueadmin.mapper.UserMapper;
import com.example.vueadmin.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.findPage(pageNum, pageSize);
        Integer total = userMapper.total();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;

    }

    public HashMap<String, String> login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> index = userMapper.login(username, password);
        Map<String, String> payload = new HashMap<>();
        payload.put("username", username);
        String token = JwtUtil.sign(user);
        if (index.size() > 0) {
            return new HashMap<String, String>() {{
                put("token", token);
                put("username", user.getUsername());
                put("msg", "登录成功");
                put("status", "true");

            }};
        } else {
            return new HashMap<String, String>() {{
                put("msg", "用户名或密码错误");
                put("status", "false");
            }};
        }


    }

    public String register(User user) {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            user.setUuid(uuid);
        }
        List<User> data = userMapper.select(user);
        if (data.size() == 0) {
            userMapper.insert(user);
            return "注册成功";
        } else {
            return "该用户已存在";
        }


    }


}
