package com.winternship.companyinfoservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.winternship.companyinfoservice.entity.Company;

@Repository
public interface CompanyInfoRepository extends JpaRepository<Company, Long> {

}
