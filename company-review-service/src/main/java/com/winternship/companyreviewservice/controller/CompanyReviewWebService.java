package com.winternship.companyreviewservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winternship.companyreviewservice.entity.Review;
import com.winternship.companyreviewservice.repository.CompanyReviewRepository;

@RestController
@RequestMapping("/reviews")
public class CompanyReviewWebService {
	
	private final CompanyReviewRepository companyReviewRepository;
	
	public CompanyReviewWebService(CompanyReviewRepository companyReviewRepository) {
		this.companyReviewRepository = companyReviewRepository;
	}
	
	@GetMapping
	public Iterable<Review> getAll(){
		return this.companyReviewRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Review getCompany(@PathVariable("id") long id) {
		return this.companyReviewRepository.findById(id).get();
		
	}

}
