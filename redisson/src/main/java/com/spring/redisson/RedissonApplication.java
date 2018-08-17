package com.spring.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
@Configuration
public class RedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonApplication.class, args);
    }

    @Autowired
    private Environment env;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        String[] profiles = env.getActiveProfiles();
        String profile = "";
        if (profiles.length > 0) {
            profile = "-" + profiles[0];
        }
        RedissonClient redissonClient = Redisson.create(
                Config.fromYAML(new ClassPathResource("redis" + profile + ".yml").getInputStream())
        );
        return redissonClient;
    }
}
