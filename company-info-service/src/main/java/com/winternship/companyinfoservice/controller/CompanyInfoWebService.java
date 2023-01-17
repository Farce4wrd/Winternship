package com.winternship.companyinfoservice.controller;

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

import com.winternship.companyinfoservice.entity.Company;
import com.winternship.companyinfoservice.exception.BadRequestException;
import com.winternship.companyinfoservice.exception.NotFoundException;
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
	public Company getCompanyCompany(@PathVariable("id") long id) {
		Optional<Company> Company = this.companyRepo.findById(id);
		if(Company.isEmpty()) {
			throw new NotFoundException("id not found "+id); 
		}
		return this.companyRepo.findById(id).get();
	}
	
	@PutMapping("/{id}")
	 @ResponseStatus(HttpStatus.ACCEPTED)
	 public void updateRecruiter(@PathVariable("id") Long id, @RequestBody Company company) {
		 if (id != company.getCompanyId()) {
			 System.out.println("Does this id exist?"+id);
			 System.out.println("Does this comapny id exist?"+ company.getCompanyId());
			 System.out.println(company);
			 throw new BadRequestException("incoming id in body doesn't match path");
		 }
		 this.companyRepo.save(company);
	 }
	
	
	@PostMapping()
	public Company addCompany(@RequestBody Company company) {
		return this.companyRepo.save(company);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable("id")long id) {
		this.companyRepo.deleteById(id);
	}

}
