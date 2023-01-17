package com.winternship.companyinternshipservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.winternship.companyinternshipservice.entity.Recruiter;
import com.winternship.companyinternshipservice.entity.Review;

@FeignClient("companyreviewservice")
public interface ReviewClient {
	
	@GetMapping("/reviews")
	List<Review> getAllReviews();
	
	@GetMapping("/reviews/{id}")
	Review getReview(@PathVariable("id") long id);
	
	@PostMapping("/reviews")
	Recruiter addReview(@RequestBody Review review);
	
	@PutMapping("/reviews/{id}")
	void updateReview(@PathVariable("id") long id, @RequestBody Review review);
	
	@DeleteMapping("/reviews/{id}")
	void deleteReview(@PathVariable("id") long id);
	

}
