package com.springbootmicroservices.rediscachedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootMicroserviceRedisCacheDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroserviceRedisCacheDemoApplication.class, args);
	}

}
