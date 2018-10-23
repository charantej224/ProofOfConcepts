package com.esbutility.application.processor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esbutility.application.config.ApiConfiguration;
import com.esbutility.application.config.ApplicationContextConfiguration;
import com.esbutility.application.config.EsbResponseQuery;
import com.esbutility.application.utils.TemplateLoader;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

@Component
public class ResponseProcessor {
	
	@Autowired
	ApplicationContextConfiguration appConfig;
	
	@Autowired
	TemplateLoader templateLoader;

	ApiConfiguration apiConfig;
	Map<String,Object> paramsMap;

	
	public String processResponse(String apiKey,String value) {
		paramsMap = new HashMap<>();
		apiConfig = appConfig.getApplicationConfigMap().get(apiKey);
		
		for(EsbResponseQuery esbQueries : apiConfig.getEsbResponseQueries()) {
			
			if("jsonArray".equalsIgnoreCase(esbQueries.getType())) {
				JSONArray jsonArray = JsonPath.read(value, esbQueries.getJsonPath());
				paramsMap.put(esbQueries.getName(),jsonArray);
			} if("String".equalsIgnoreCase(esbQueries.getType())) {
				String jsonString = JsonPath.read(value, esbQueries.getJsonPath());
				paramsMap.put(esbQueries.getName(),jsonString);
			}
			
		}	
		return templateLoader.loadTemplate(apiConfig.getResponseMustacheTemplate()).execute(paramsMap);
		
	}


}
