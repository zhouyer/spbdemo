package com.zhouyer.spbdemo;

import com.zhouyer.spbdemo.entity.User;
import com.zhouyer.spbdemo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpbDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setAge(24);
        user.setSex(1);
        user.setBirthday(new Date());
        userRepository.save(user);
    }
}
