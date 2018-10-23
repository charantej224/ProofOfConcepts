package com.esbutility.application.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.esbutility.application.config.ApiConfiguration;
import com.esbutility.application.config.ApplicationContextConfiguration;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JSONFileLoader {
	
	@Value("${application.apiKeys}")    
	String[] apiKeysArray;

	@Autowired
	ApplicationContextConfiguration configuration;

	@Autowired
	private ResourceLoader resourceLoader;
	
	Logger logger = LoggerFactory.getLogger(JSONFileLoader.class);

	ObjectMapper objectMapper = new ObjectMapper();

	ApiConfiguration apiConfiguration;

	public String getFileAsString(String fileName) throws IOException {
		Resource resource = resourceLoader.getResource("classpath:jsonconfig/" + fileName);
		return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
	}

	public void getMapWithJsonConfig()
			throws JsonParseException, JsonMappingException, IOException {
		for (String apiKey : apiKeysArray) {
			apiConfiguration = objectMapper.readValue(getFileAsString(apiKey+".json"), ApiConfiguration.class);
			configuration.getApplicationConfigMap().put(apiKey, apiConfiguration);
		}
		logger.info(String.valueOf(configuration.getApplicationConfigMap().size()));
		
	}
	
	@PostConstruct
	public void init() throws JsonParseException, JsonMappingException, IOException {
		getMapWithJsonConfig();
	}

}
