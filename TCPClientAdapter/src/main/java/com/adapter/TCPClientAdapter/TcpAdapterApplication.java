package com.adapter.TCPClientAdapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.adapter.TCPClientAdapter.service.ClientService;

@SpringBootApplication
@EnableHystrixDashboard
@EnableEurekaClient
@EnableCircuitBreaker
public class TcpAdapterApplication implements CommandLineRunner {

	@Autowired
	private ClientService clientService;
	private static final Logger LOGGER = LogManager.getLogger(TcpAdapterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TcpAdapterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			try {
				clientService.maintainConnection();
			} catch (Exception e) {
				LOGGER.error(this.getClass().getName(), e);
			}
		}
	}

}
