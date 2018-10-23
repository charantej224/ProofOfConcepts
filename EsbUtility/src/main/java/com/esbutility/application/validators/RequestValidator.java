package com.esbutility.application.validators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esbutility.application.config.ApiConfiguration;
import com.esbutility.application.config.ApplicationContextConfiguration;
import com.esbutility.application.config.ExpectedParameter;
import com.jayway.jsonpath.JsonPath;

@Component
public class RequestValidator {
	
	private static Logger logger = LoggerFactory.getLogger(RequestValidator.class);
	
	@Autowired
	ApplicationContextConfiguration appConfig;
	
	ApiConfiguration apiConfig;
	
	public boolean validate(String apiKey,String content) {
		
		apiConfig = appConfig.getApplicationConfigMap().get(apiKey);
		try {
			for(ExpectedParameter expectParams : apiConfig.getExpectedParameters()) {
				if(null == JsonPath.read(content, expectParams.getJsonpathPattern())) {
					return false;
				}
			}
			return true;
		} catch(Exception exception) {
			logger.error("Exception during validation", exception);
			return false;
		}
		
	}
}
