package com.adapter.TCPClientAdapter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RestCaller {
	
//	@Autowired
//	private RestTemplate restClient;
	
	
	@HystrixCommand(fallbackMethod = "sendToRest_Fallback")
	public boolean sendToRest(String message, String url){
		System.err.println(url);
		RestTemplate restClient = new RestTemplate();
		String respone = restClient.postForObject(url, message, String.class);
		if(respone.equals("success"))
			return true;
		else
			return false;
		
	}
	
	   @SuppressWarnings("unused")
	    private boolean sendToRest_Fallback(String message, String url) {
	 
	        System.out.println("******************fallback method called****************");
	 
	        return false;
	    }

}
