package com.example.mvctest.junit4;

import com.example.mvctest.controller.UserController;
import com.example.mvctest.dao.User;
import com.example.mvctest.service.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// junit 4 version
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringRunner.class)
//@Test
//TestMethod(){}

//junit 5
//import org.junit.jupiter.api.Test;
//this @Test and needn't add RunWith nor SpringRunner
/**
 * @Description htpp接口层测试 service层 Mock
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 11:26
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserService userService;


    @Test
    public void user_controller_mock_service_test() throws Exception{
        User user =new User();
        user.setId(1L);
        when(userService.findById(user.getId())).thenReturn(user);

       this.mockMvc.perform(get("/user?id=1").contentType(MediaType.APPLICATION_JSON)).andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id",CoreMatchers.is(1)));
    }

}
