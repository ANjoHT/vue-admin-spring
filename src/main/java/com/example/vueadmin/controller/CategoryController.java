package com.example.vueadmin.controller;

import com.example.vueadmin.entity.Category;
import com.example.vueadmin.responseEntity.ServerResponse;
import com.example.vueadmin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/query")
    public ServerResponse query() {
        return ServerResponse.ok(categoryService.query());
    }

    @PostMapping("/add")
    public ServerResponse add(@RequestBody Category category) {
        return ServerResponse.ok(categoryService.add(category));
    }

}
