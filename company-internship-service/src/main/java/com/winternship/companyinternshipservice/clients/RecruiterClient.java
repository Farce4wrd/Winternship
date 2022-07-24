package com.winternship.companyinternshipservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.winternship.companyinternshipservice.entity.Recruiter;

@FeignClient("recruiterservice")
public interface RecruiterClient {

	@GetMapping("/recruiters")
	List<Recruiter> getAllRecruiters();
	
	@GetMapping("/recruiters/{id}")
	Recruiter getRecruiter(@PathVariable("id") long id);
}
