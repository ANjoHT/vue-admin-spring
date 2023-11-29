package com.example.vueadmin.controller;

import com.example.vueadmin.entity.ShUser;
import com.example.vueadmin.mapper.ShUserMapper;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.ShUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/shUser")
public class ShUserController {
    @Autowired
    private ShUserMapper shUserMapper;

    @Autowired
    private ShUserService shUserService;

    @GetMapping("/getUser")
    public ServerResponse getUserList(@RequestParam Integer pageSize, Integer pageNumber) {
        Map<String, Object> res = shUserService.getUserList(pageSize, pageNumber);
        return ServerResponse.ok(res);
    }

    @PostMapping("/addUser")
    public ServerResponse addUser(@RequestBody ShUser shUser) {
        Integer res = shUserService.addUser(shUser);
        if (res == 0) {
            return ServerResponse.badRequest("用户已存在");
        } else {
            return ServerResponse.ok("创建成功");
        }
    }

    @DeleteMapping("/deleteUser")
    public ServerResponse deleteUser(@RequestParam Integer id) {
        Integer res = shUserService.deleteUser(id);
        if (res == 1) {
            return ServerResponse.ok("删除成功");
        } else {
            return ServerResponse.badRequest("删除失败");
        }
    }
}
