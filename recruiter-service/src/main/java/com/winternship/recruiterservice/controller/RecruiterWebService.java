package com.winternship.recruiterservice.controller;

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

import com.winternship.recruiterservice.entity.Recruiter;
import com.winternship.recruiterservice.exception.BadRequestException;
import com.winternship.recruiterservice.exception.NotFoundException;
import com.winternship.recruiterservice.repo.RecruiterRepository;

@RestController
@RequestMapping("/recruiters")
public class RecruiterWebService {

	private final RecruiterRepository recruiterRepo;
	
	public RecruiterWebService(RecruiterRepository recruiterRepo) {
		this.recruiterRepo = recruiterRepo;
	}
	
	@GetMapping
	public Iterable<Recruiter> getAll() {
		return this.recruiterRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Recruiter getRecruiter(@PathVariable("id") long id) {
		Optional<Recruiter> recruiter = this.recruiterRepo.findById(id);
		if(recruiter.isEmpty()) {
			throw new NotFoundException("id not found "+id); 
		}
		return this.recruiterRepo.findById(id).get();
	}
	
	 @PutMapping("/{id}")
	 @ResponseStatus(HttpStatus.ACCEPTED)
	 public void updateRecruiter(@PathVariable("id") Long id, @RequestBody Recruiter recruiter) {
		 if (id != recruiter.getId()) {
			 throw new BadRequestException("incoming id in body doesn't match path");
		 }
		 this.recruiterRepo.save(recruiter);
	 }
	
	@PostMapping()
	public Recruiter addRecruiter(@RequestBody Recruiter recruiter) {
		return this.recruiterRepo.save(recruiter);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteRecruiter(@PathVariable("id")long id) {
		this.recruiterRepo.deleteById(id);
	}
}
