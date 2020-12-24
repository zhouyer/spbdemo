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
        user.setUsername("admin2");
        user.setPassword("12345678");
        user.setAge(23);
        user.setSex(2);
        user.setBirthday(new Date());
        userRepository.save(user);
    }


}
