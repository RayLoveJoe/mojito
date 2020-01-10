package com.wuleilei.mojito;

import com.wuleilei.mojito.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FirstSampleApplicationTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testObject(){
        UserInfo userInfo = new UserInfo();
        userInfo.setAccount("123456");
        userInfo.setEmail("123456@qq.com");
        userInfo.setNickname("zhuzhu");
        //保存对象
        redisTemplate.opsForValue().set("user",userInfo);
        System.out.println("result:"+ stringRedisTemplate.opsForValue().get("user"));
    }

    @Test
    public void testString(){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("zhuzhu");
        //保存对象
       stringRedisTemplate.opsForValue().set("username",userInfo.getNickname());
        System.out.println("result:"+ stringRedisTemplate.opsForValue().get("username"));
    }

    @Test
    public void testStringByTime(){
        UserInfo userInfo = new UserInfo();
        userInfo.setNickname("zhuzhu");
        //保存对象
        stringRedisTemplate.opsForValue().set("username",userInfo.getNickname(),1,TimeUnit.MINUTES);
        System.out.println("result:"+ stringRedisTemplate.opsForValue().get("username"));
    }
}
