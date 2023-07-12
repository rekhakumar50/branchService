package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
	
	Branch findByBranchCode(String branchCode);

}
