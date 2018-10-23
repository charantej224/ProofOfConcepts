package com.esbutility.application.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esbutility.application.config.ApiConfiguration;
import com.esbutility.application.config.ApplicationContextConfiguration;
import com.esbutility.application.config.RequestGeneratedParam;
import com.esbutility.application.utils.TemplateLoader;
import com.jayway.jsonpath.JsonPath;

@Component
public class RequestProcessor {
	
	private static Logger logger = LoggerFactory.getLogger(RequestProcessor.class);
	
	@Autowired
	ApplicationContextConfiguration appConfig;
	
	@Autowired
	TemplateLoader templateLoader;
	
	Map<String,Object> generateParamsMap;
	
	ApiConfiguration apiConfig;
	
	public String processRemoteRequest(String apiKey, String content) {
		generateParamsMap = new HashMap<>();
		apiConfig = appConfig.getApplicationConfigMap().get(apiKey);
		List<RequestGeneratedParam> requestGeneratedParamsList = apiConfig.getRequestGeneratedParams();
		setupRequestParams(requestGeneratedParamsList,content,generateParamsMap);
		return templateLoader.loadRequestTemplate(apiConfig.getRequestTemplate()).execute(generateParamsMap);
	}
	
	public void setupGenerateParams(List<RequestGeneratedParam> requestGeneratedParamsList,String content,Map<String,Object> generateParamsMap) {
		
	}
	
	public void setupRequestParams(List<RequestGeneratedParam> requestGeneratedParamsList,String content,Map<String,Object> generateParamsMap) {
		for(RequestGeneratedParam requestGeneratedParam : requestGeneratedParamsList) {
			String value = JsonPath.read(content, requestGeneratedParam.getGeneratorMethod());
			generateParamsMap.put(requestGeneratedParam.getName(), value);
		}
		
	}
	
	

}
