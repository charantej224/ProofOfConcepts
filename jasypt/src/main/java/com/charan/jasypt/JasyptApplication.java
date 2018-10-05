package com.charan.jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.charan")
public class JasyptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasyptApplication.class, args);
	}
}
