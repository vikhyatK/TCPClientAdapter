package com.adapter.TCPClientAdapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SocketAdapterConfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
