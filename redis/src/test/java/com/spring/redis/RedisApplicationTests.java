package com.spring.redis;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @Test
    //直接使用redisTemplate存取字符串
    public void setAndGet() {
        redisTemplate.opsForValue().set("test:set", "testValue1");
        Assert.assertEquals("testValue1", redisTemplate.opsForValue().get("test:set"));
    }

    @Test
    //直接使用redisTemplate存取对象
    public void setAndGetAUser() {
        User user = new User("Tom", 10);
        redisTemplate.opsForValue().set("test:setUser", user);
        Assert.assertEquals(user.getUsername(), ((User) redisTemplate.opsForValue().get("test:setUser")).getUsername());
    }

    //使用Redis缓存对象，getUser只会被调用一次
    @Test
    public void testCache() {
        User user;
        user = userService.getUser("Ttomm");
        user = userService.getUser("Ttomm");
        user = userService.getUser("Ttomm");
    }

}
