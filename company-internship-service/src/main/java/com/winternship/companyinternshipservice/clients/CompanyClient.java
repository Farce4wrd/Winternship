package com.winternship.companyinternshipservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.winternship.companyinternshipservice.entity.Company;
import com.winternship.companyinternshipservice.entity.Recruiter;

@FeignClient("companyinfoservice")
public interface CompanyClient {
	
	@GetMapping("/companies")
	List<Company> getAllCompanies();
	
	@GetMapping("/companies/{id}")
	Company getCompany(@PathVariable("id") long id);
	
	@PostMapping("/companies")
	Recruiter addCompany(@RequestBody Company company);
	
	@PutMapping("/companies/{id}")
	void updateCompany(@PathVariable("id") long id, @RequestBody Company company);
	
	@DeleteMapping("/companies/{id}")
	void deleteCompany(@PathVariable("id") long id);
}
