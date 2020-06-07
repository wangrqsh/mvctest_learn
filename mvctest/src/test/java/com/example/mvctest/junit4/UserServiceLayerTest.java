package com.example.mvctest.junit4;


import com.example.mvctest.dao.User;
import com.example.mvctest.dao.UserRepository;
import com.example.mvctest.service.UserService;
import com.example.mvctest.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;


// junit 4 version
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringRunner.class)
//@Test on method

//junit 5
//import org.junit.jupiter.api.Test;
//this @Test and needn't add RunWith nor SpringRunner


/**
 * @Description 仅Service 层测试 dao层 Mock
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 11:06
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
public class UserServiceLayerTest {

    @TestConfiguration
    static class ServiceTestConfiguer{
        @Bean
        public UserService userService(){
        return new UserServiceImpl();
      }
    }

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;

    @Before
    public void setUp(){
        User user =new User();
        user.setId(1L);
        user.setAddress("上海");
        user.setName("Jim");
        user.setAge(8);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
    }

    @Test
    public  void user_service_mock_dao_test(){
        Assertions.assertThat(userService.findById(1L).getId()).isEqualTo(1L);
    }
}
