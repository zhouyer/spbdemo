package com.zhouyer.spbdemo.study.lock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName RedisSetNxDemo
 * @Description Redis setnx 命令 demo
 * @Author zhouyer
 * @Date 2020/6/3 23:34
 * @Version 1.0
 **/
@SpringBootTest
public class RedisSetNxDemo {
    @Autowired
    private JedisPool jedisPool;


    @Test
    public void jedisTest() {
        Jedis jedis = jedisPool.getResource();
        //setnx key value   只有当key不存在时才会设置成功，如果存在，什么都不操作
        String result = jedis.set("lock", "xx", "NX", "PX", 100000);
        System.out.println(result);
        jedis.close();
    }
}
