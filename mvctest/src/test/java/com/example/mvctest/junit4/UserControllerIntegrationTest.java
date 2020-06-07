package com.example.mvctest.junit4;

import com.example.mvctest.MyApplication;
import com.example.mvctest.dao.User;
import com.example.mvctest.service.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description 启动完整的serverlet容器测试,没有mock的对象
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 下午 12:32
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MyApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserService userService;


    @Test
    public void web_user_get_test() throws Exception{
        createTestUser();
        this.mockMvc.perform(get("/user?id=1").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", CoreMatchers.is(1)));
    }

   void createTestUser(){
       User user =new User();
       user.setId(1L);
       userService.save(user);
    }
}
