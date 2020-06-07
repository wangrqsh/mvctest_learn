package com.example.mvctest.junit4;

import com.example.mvctest.dao.User;
import com.example.mvctest.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Description dao 层测试 内存数据库
 * @Author Administrator
 * @Email wangrqsh@163.com
 * @Date 2020/6/7 0007 上午 0:21
 * @Version 1.0
 */
// junit 4 version
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringRunner.class)
//@Test on method

//junit 5
//import org.junit.jupiter.api.Test;
//this @Test and needn't add RunWith nor SpringRunner

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserDaoLayerTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void user_dao_test(){
        User user =new User();
        user.setAddress("上海");
        user.setName("Jim");
        user.setAge(8);
        entityManager.persist(user);
        entityManager.flush();

        User byName = userRepository.findByName(user.getName());
        assertThat(byName.getName()).isEqualTo(user.getName());
    }
}
