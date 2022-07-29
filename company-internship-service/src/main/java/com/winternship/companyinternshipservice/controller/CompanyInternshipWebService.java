package com.winternship.companyinternshipservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winternship.companyinternshipservice.clients.CompanyClient;
import com.winternship.companyinternshipservice.clients.RecruiterClient;
import com.winternship.companyinternshipservice.clients.ReviewClient;

@RestController
@RequestMapping("/internship")
public class CompanyInternshipWebService {
	
	private final CompanyClient companyClient;
	private final RecruiterClient recruiterClient;
	private final ReviewClient reviewClient;
	
	public CompanyInternshipWebService(CompanyClient companyClient, RecruiterClient recruiterClient, ReviewClient reviewClient) {
		this.companyClient =companyClient;
		this.recruiterClient = recruiterClient;
		this.reviewClient = reviewClient;
	}
	
	@GetMapping("/test")
	public String test() {
		return "This was a test for security";
	}
	
	

}
