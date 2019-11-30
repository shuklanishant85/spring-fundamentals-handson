package com.spring.rest.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.spring.rest")
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJacksonHttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJacksonHttpMessageConverter();
		mappingJacksonHttpMessageConverter.setObjectMapper(new ObjectMapper());
		restTemplate.getMessageConverters().add(mappingJacksonHttpMessageConverter);
		return restTemplate;
	}
}
