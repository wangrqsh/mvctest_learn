package com.example.mvctest.controller;

import com.example.mvctest.dao.User;
import com.example.mvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/6 0006 下午 23:28
 * @Version 1.0
 */
@RestController
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/userList")
    public List<User> getUserList(){
        return  userService.findAll();
    }
    @GetMapping("/user")
    public User getUser(Long id){
        return  userService.findById(id);
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return  userService.save(user);
    }
}
