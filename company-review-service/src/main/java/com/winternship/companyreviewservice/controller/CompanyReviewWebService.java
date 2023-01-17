package com.winternship.companyreviewservice.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.winternship.companyreviewservice.entity.Review;
import com.winternship.companyreviewservice.exception.BadRequestException;
import com.winternship.companyreviewservice.exception.NotFoundException;
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
	public Review getCompanyReview(@PathVariable("id") long id) {
		Optional<Review> review = this.companyReviewRepository.findById(id);
		if(review.isEmpty()) {
			throw new NotFoundException("id not found "+id); 
		}
		return this.companyReviewRepository.findById(id).get();
	}
	
	@PutMapping("/{id}")
	 @ResponseStatus(HttpStatus.ACCEPTED)
	 public void updateRecruiter(@PathVariable("id") Long id, @RequestBody Review review) {
		 if (id != review.getId()) {
			 throw new BadRequestException("incoming id in body doesn't match path");
		 }
		 this.companyReviewRepository.save(review);
	 }
	
	
	@PostMapping()
	public Review addRecruiter(@RequestBody Review recruiter) {
		return this.companyReviewRepository.save(recruiter);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteRecruiter(@PathVariable("id")long id) {
		this.companyReviewRepository.deleteById(id);
	}

}
