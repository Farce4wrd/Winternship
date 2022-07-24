package com.winternship.companyinternshipservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.winternship.companyinternshipservice.entity.Company;

@FeignClient("companyinfoservice")
public interface CompanyClient {
	
	@GetMapping("/companies")
	List<Company> getAllCompanies();
	
	@GetMapping("/companies/{id}")
	Company getCompany(@PathVariable("id") long id);
}
