package com.charan.jasypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Value("${user.password}")
	private String password;
	

	@GetMapping("/getDecryptedPassword")
	public String getDecryrptedPassword() {
		return password;
		
	}
	
}
