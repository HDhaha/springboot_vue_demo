package com.springboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.commen.Result;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
@author 申浩东
*/
@RestController
@RequestMapping("/user")
//@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/saveUser")
    public Result<?> save(@RequestBody User user){
        return userService.insert(user);
    }
    @PutMapping("/updateUser")
    public Result<?> update(@RequestBody User user){
        return userService.update(user);
    }
    @DeleteMapping("/deleteUser")
    public Result<?> delete(Integer id){
        return userService.delete(id);
    }
    @GetMapping("/findPage")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
//        System.out.println();
        Page userPage = userService.selectPage(pageNum, pageSize,search);
        return Result.success(userPage);
    }
}
