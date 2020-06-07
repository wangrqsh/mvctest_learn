package com.example.mvctest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 9:44
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String Hello() {
        return "Hello, World";
    }
}
