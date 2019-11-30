package com.spring.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value="com.spring.main")
public class MyConfiguration {

	@Bean
	public MyService myService() {
		return new MyService();
	}
}
