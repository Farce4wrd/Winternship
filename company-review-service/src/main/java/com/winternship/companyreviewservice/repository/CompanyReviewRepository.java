package com.winternship.companyreviewservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.winternship.companyreviewservice.entity.Review;

@Repository
public interface CompanyReviewRepository extends JpaRepository<Review, Long> {
	

}
