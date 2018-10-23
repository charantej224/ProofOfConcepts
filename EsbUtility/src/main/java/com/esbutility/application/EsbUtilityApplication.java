package com.esbutility.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import com.esbutility.application.utils.JSONFileLoader;

@SpringBootApplication
@ComponentScan("com.esbutility")
public class EsbUtilityApplication {
	
	@Autowired
	JSONFileLoader jsonFileLoader;

	public static void main(String[] args) {
		SpringApplication.run(EsbUtilityApplication.class, args);
	}
	
	
	@Bean
	@Scope("prototype")
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
