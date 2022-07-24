package com.winternship.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerWinternshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerWinternshipApplication.class, args);
	}

}
