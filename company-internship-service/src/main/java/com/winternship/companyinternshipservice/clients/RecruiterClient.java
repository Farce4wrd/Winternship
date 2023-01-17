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

@FeignClient("recruiterservice")
public interface RecruiterClient {

	@GetMapping("/recruiters")
	List<Recruiter> getAllRecruiters();
	
	@GetMapping("/recruiters/{id}")
	Recruiter getRecruiter(@PathVariable("id") long id);
	
	@PostMapping("/recruiters")
	Recruiter addRecruiter(@RequestBody Recruiter recruiter);
	
	@PutMapping("/recruiters/{id}")
	void updateRecruiter(@PathVariable("id") long id, @RequestBody Recruiter recruiter);
	
	@DeleteMapping("/recruiters/{id}")
	void deleteRecruiter(@PathVariable("id") long id);
}
