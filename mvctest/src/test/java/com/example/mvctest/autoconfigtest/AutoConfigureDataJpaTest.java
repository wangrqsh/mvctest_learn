package com.example.mvctest.autoconfigtest;

import com.example.mvctest.dao.User;
import com.example.mvctest.dao.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)//使用真实数据库
public class AutoConfigureDataJpaTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void dao_user_test(){

        User user = new User("leo",5,"合肥");
        entityManager.persist(user);
        entityManager.flush();

        User byName = userRepository.findByName(user.getName());
        assertThat(byName.getName()).isEqualTo(user.getName());
    }



}
