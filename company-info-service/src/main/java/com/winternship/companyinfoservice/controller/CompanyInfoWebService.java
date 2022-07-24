package com.winternship.companyinfoservice.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winternship.companyinfoservice.entity.Company;
import com.winternship.companyinfoservice.repo.CompanyInfoRepository;

@RestController
@RequestMapping("/companies")
public class CompanyInfoWebService {
	
	private final CompanyInfoRepository companyRepo;
	
	public CompanyInfoWebService(CompanyInfoRepository companyRepo) {
		this.companyRepo = companyRepo;
	}
	
	@GetMapping
	public Iterable<Company> getAll(){
		return this.companyRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Company getCompany(@PathVariable("id") long id) {
		//Optional<Company> temp = this.companyRepo.findById(id);
		
		return this.companyRepo.findById(id).get();
	}

}
