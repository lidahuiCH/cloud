package com.spring.redis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    @Cacheable(value = "user", key = "'user_'+#username")
    public User getUser(String username) {
        System.out.println(username + "进入实现类获取数据！");
        return new User("Ttomm", 22);
    }
}
