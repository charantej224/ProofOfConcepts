package com.esbutility.application.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ApplicationContextConfiguration {
	
	private Map<String, ApiConfiguration> applicationConfigMap;
	

	public Map<String, ApiConfiguration> getApplicationConfigMap() {
		if(applicationConfigMap == null) {
			applicationConfigMap = new HashMap<>();
		}
		return applicationConfigMap;
	}	

}
