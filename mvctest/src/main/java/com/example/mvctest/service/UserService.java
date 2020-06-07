package com.example.mvctest.service;


import com.example.mvctest.dao.User;

import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 11:03
 * @Version 1.0
 */
public interface UserService {
    User  findByName(String name);

    User findById(Long id);

    User save(User user);

    List<User> findAll();

}
