package com.adapter.TCPClientAdapter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RestCaller {
	private static final Logger LOGGER = LogManager.getLogger(RestCaller.class);

	@Autowired
	private RestTemplate restClient;

	@HystrixCommand(fallbackMethod = "sendToRest_Fallback")
	public boolean sendToRest(String message, String url) {
		LOGGER.info("Calling URL: {} with message: {}", url, message);
		String respone = restClient.postForObject(url, message, String.class);
		LOGGER.info("Called URL: {} and response is: {}", url, respone);
		if (respone.equals("success"))
			return true;
		else
			return false;
	}

	@SuppressWarnings("unused")
	private boolean sendToRest_Fallback(String message, String url) {
		LOGGER.info("Fallback method is called");
		return false;
	}

}
