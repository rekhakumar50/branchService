package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Branch;
import com.example.demo.dto.BranchDto;
import com.example.demo.service.BranchService;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping
	public ResponseEntity<String> saveBranch(@RequestBody BranchDto branchDto) {
		try {
			Branch branch = branchService.saveBranch(branchDto);
			if(Objects.nonNull(branch)) {
				return new ResponseEntity<String>("Branch Data Saved!!", HttpStatus.CREATED);
			}
			return new ResponseEntity<String>("Branch Data Not Saved!!", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(Exception e) {
			return new ResponseEntity<String>("Branch Data Not Saved!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<BranchDto>> getBranches() {
		List<BranchDto> branchDtos = branchService.getBranches();
		return new ResponseEntity<List<BranchDto>>(branchDtos, HttpStatus.OK);
	}
	
	@GetMapping("/{branchCode}")
	public ResponseEntity<BranchDto> getBranchByCode(@PathVariable String branchCode) {
		BranchDto branchDto = branchService.getBranchByCode(branchCode);
		return new ResponseEntity<BranchDto>(branchDto, HttpStatus.OK);
	}

}
