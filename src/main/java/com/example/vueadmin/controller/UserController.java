package com.example.vueadmin.controller;

import com.example.vueadmin.entity.User;
import com.example.vueadmin.mapper.UserMapper;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @GetMapping("/select")
    public ServerResponse query(@RequestParam String username) {
        String data = userMapper.findUser(username);
        return ServerResponse.ok(data);

    }

    @PostMapping("/login")
    public ServerResponse login(@RequestBody User user) {

        HashMap<String, String> map = userService.login(user);
        if (map.get("msg") == "登录成功") {
            return ServerResponse.ok(map);
        } else {
            return ServerResponse.unauthorized(map);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ServerResponse delete(@PathVariable Integer id) {
        Integer data = userMapper.delete(id);
        return ServerResponse.ok(data);
    }

    @GetMapping("/page")
    public ServerResponse findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Map<String, Object> data = userService.findPage(pageNum, pageSize);
        return ServerResponse.ok(data);
    }

    @PostMapping("/register")
    public ServerResponse register(@RequestBody User user) {
        String data = userService.register(user);
        if (data == "注册成功") {
            return ServerResponse.ok(data);
        } else {
            return ServerResponse.badRequest(data);
        }
    }




    @PostMapping("/update")
    public ServerResponse update(@RequestBody String username, String password) {
        List<User> data = userMapper.login(username, password);
        if (data.size() == 1) {
            userMapper.update(password);
            return ServerResponse.ok("修改成功");
        } else {
            return ServerResponse.badRequest("修改失败");
        }

    }


}
