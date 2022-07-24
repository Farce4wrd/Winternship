package com.winternship.companyinternshipservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.winternship.companyinternshipservice.entity.Review;

@FeignClient("companyreviewservice")
public interface ReviewClient {
	
	@GetMapping("/reviews")
	List<Review> getAllReviews();
	
	@GetMapping("/reviews/{id}")
	Review getReview(@PathVariable("id") long id);
	

}
