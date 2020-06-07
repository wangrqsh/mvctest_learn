package com.example.mvctest.autoconfigtest;

import com.example.mvctest.controller.UserController;
import com.example.mvctest.dao.User;
import com.example.mvctest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Description @WebMvcTest注解：只扫描有限类型的bead来测试,只测试控制层的逻辑,service层数据通过 mock处理,
 *  (limit scanned beans to @Controller, @ControllerAdvice, @JsonComponent, Filter, WebMvcConfigurer and HandlerMethodArgumentResolver.
 *  Regular @Component beans will not be scanned when using this annotation)
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 下午 15:57
 * @Version 1.0
 */
@WebMvcTest(UserController.class)
public class AutoConfigureMvcTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    public void mvc_user_test() throws Exception {

        List<User> userList = new ArrayList<>(2);
        userList.add(new User(1L,"john",3,"beijing"));
        userList.add(new User(2L,"jay",4,"shanghai"));
        given(userService.findAll()).willReturn(userList);

        this.mvc.perform(get("/userList").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(1)));
    }
}
