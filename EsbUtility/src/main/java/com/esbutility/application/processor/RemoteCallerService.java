package com.esbutility.application.processor;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esbutility.application.config.ApiConfiguration;
import com.esbutility.application.config.ApplicationContextConfiguration;

@Service
public class RemoteCallerService {

	@Autowired
	ApplicationContextConfiguration appConfig;

	ApiConfiguration apiConfig;

	@Autowired
	RestTemplate restTemplate;

	public String fireRemotePostRequest(String apiKey, String value) throws URISyntaxException {
		apiConfig = appConfig.getApplicationConfigMap().get(apiKey);
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(value, requestHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(apiConfig.getEndpoint(), HttpMethod.POST,
				requestEntity, String.class);

		return responseEntity.getBody();
	}

}
