package com.winternship.companyreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompanyReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyReviewServiceApplication.class, args);
	}

}
