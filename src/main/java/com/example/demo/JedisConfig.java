package com.example.demo;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class JedisConfig {

    @Bean
    public Jedis jedis(RedisProperties redisProperties) {
        //System.out.printf("Creating Jedis connector to %s:%s%n", redisProperties.getHost(), redisProperties.getPort());
        return new Jedis(redisProperties.getHost(), redisProperties.getPort());
    }
}