package com.amao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisBean {
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory cf = null;

        cf = new JedisConnectionFactory();
        cf.setHostName("127.0.0.1");
        cf.setPort(6379);
        cf.setDatabase(1);
        cf.setPassword("root");
        cf.setTimeout(30000);
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(30000);
        poolConfig.setMaxTotal(5);
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(2);
        cf.setPoolConfig(poolConfig);

        cf.afterPropertiesSet();
        return cf;
    }
    @Bean
    public org.springframework.data.redis.core.RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
        return template;
    }
}
