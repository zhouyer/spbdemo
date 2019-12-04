package com.zhouyer.spbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbDemoApplication.class, args);
    }

}
