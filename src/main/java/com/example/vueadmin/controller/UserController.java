package com.example.vueadmin.controller;

import com.example.vueadmin.entity.User;
import com.example.vueadmin.mapper.UserMapper;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ServerResponse query(){
        List<User> data =  userMapper.findAll();
        return ServerResponse.ok(data);

    }
    @PostMapping("/insert")
    public ServerResponse save(@RequestBody User user){
        Integer data = userService.save(user);
        return ServerResponse.ok(data);
    }

    @DeleteMapping("/delete/{id}")
    public ServerResponse delete(@PathVariable Integer id){
        Integer data = userMapper.delete(id);
        return ServerResponse.ok(data);
    }
    @GetMapping("/page")
    public ServerResponse findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        Map<String,Object> data = userService.findPage(pageNum,pageSize);
        return ServerResponse.ok(data);
    }


}
