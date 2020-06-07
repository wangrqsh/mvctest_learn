package com.example.mvctest.autoconfigtest;

import com.example.mvctest.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Description TODO
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 下午 15:37
 * @Version 1.0
 */

@JsonTest
public class AutoConfigureJsonTest {
    @Autowired
    private JacksonTester<User> json;

    @Test
    public void testSerialize() throws Exception {
        User details = new User("Honda",8, "Civic");

        // Or use JSON path based assertions
        assertThat(this.json.write(details))
                .hasJsonPathStringValue("@.name");

        assertThat(this.json.write(details))
                .extractingJsonPathStringValue("@.name")
                .isEqualTo("Honda");

        // Assert against a `.json` file in the same package as the test
//        assertThat(this.json.write(details)).isEqualToJson("expected.json");
    }


    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"id\":1,\"name\":\"Ford\",\"age\":8,\"address\":\"Focus\"}";
//        assertThat(this.json.parse(content)).isEqualTo(new User(1L,"Ford",8, "Focus"));
        assertThat(this.json.parseObject(content).getName()).isEqualTo("Ford");
    }
}
