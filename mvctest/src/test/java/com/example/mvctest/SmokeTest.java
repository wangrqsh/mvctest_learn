package com.example.mvctest;

import com.example.mvctest.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description 冒烟测试
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 9:24
 * @Version 1.0
 */
@SpringBootTest
public class SmokeTest {

    @Autowired
    private HelloController helloController;

    @Test
    void test_1() {
        assertThat(helloController).isNotNull();
    }
}
