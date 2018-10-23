package com.esbutility.application.controller;

import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.esbutility.application.processor.RemoteCallerService;
import com.esbutility.application.processor.RequestProcessor;
import com.esbutility.application.processor.ResponseProcessor;
import com.esbutility.application.validators.RequestValidator;
import com.jayway.jsonpath.JsonPath;

@RestController
public class GenericPostController {

	private static Logger logger = LoggerFactory.getLogger(GenericPostController.class);

	@Value("${apiKey.value}")
	String apiKeyLiteral;

	@Autowired
	RequestValidator validator;

	@Autowired
	RequestProcessor requestProcessor;

	@Autowired
	RemoteCallerService remoteService;

	@Autowired
	ResponseProcessor responseProcessor;

	@PostMapping("/postGenericMessage")
	public ResponseEntity<String> processPostRequest(@RequestBody String value) throws URISyntaxException {

		String apiKey = JsonPath.read(value, apiKeyLiteral);
		validator.validate(apiKey, value);
		String remoteRequest = requestProcessor.processRemoteRequest(apiKey, value);
		logger.debug(remoteRequest);
		String esbResponse = remoteService.fireRemotePostRequest(apiKey, remoteRequest);
		String finalResponse = responseProcessor.processResponse(apiKey, esbResponse);
		final HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(finalResponse,httpHeaders, HttpStatus.OK);
		return responseEntity;
	}
}
