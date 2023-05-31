package com.springbootmicroservices.rediscachedemo.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class CacheConfiguration {

	/*
	 * @Autowired private RedisConnectionFactory redisConnectionFactory;
	 * 
	 * @Bean public CacheManager cacheManager() { RedisCacheConfiguration
	 * cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
	 * .entryTtl(Duration.ofMinutes(1)); // Set time to live
	 * 
	 * return RedisCacheManager.builder(redisConnectionFactory)
	 * .cacheDefaults(cacheConfiguration) .transactionAware() .build(); }
	 */
}