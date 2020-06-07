package com.example.mvctest.service;


import com.example.mvctest.dao.User;
import com.example.mvctest.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 11:04
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User> )userRepository.findAll();
    }
}
