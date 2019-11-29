package com.aust.redis;/*
 * Copyright © 2016 睿泰集团 版权所有
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;

/**
 * @Autor zhouNan
 * @Date 2019/11/5 15:02
 * @Description CaseConfig
 **/
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {


   /* *//**
     * Jdk自带  内存管理器
     * @return
     *//*
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("product")));
        return cacheManager;
    }*/

    /**
     * redis  缓存器
     * @param connectionFactory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(
                        RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(20))) //缓存时间  绝对过期时间
                .transactionAware()
                .build();

    }


    /**
     *  spirngCache 缓存Key  生成方式
     *  target 目标类  method 目标方法  params  目标参数
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder ab = new StringBuilder();
                ab.append(target.getClass().getSimpleName());
                ab.append(method.getName());
                for (Object obj : params) {
                    ab.append(obj.toString());
                }
                return ab.toString();
            }
        };
    }


    /**
     * redis 序列化
     * @param factory
     * @return
     */
     @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

         Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

         ObjectMapper mapper = new ObjectMapper();

         mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
         mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

         serializer.setObjectMapper(mapper);

         template.setValueSerializer(serializer);
            //使用stringRedisSerializer 来序列化和反序列化redis key的值
         template.setKeySerializer(new StringRedisSerializer());
         template.afterPropertiesSet();
         return template;
    }
}
