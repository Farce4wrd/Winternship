package com.winternship.recruiterservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.winternship.recruiterservice.entity.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

}
