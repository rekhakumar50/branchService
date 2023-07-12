package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Branch;
import com.example.demo.dto.BranchDto;
import com.example.demo.mapper.BranchMapper;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	public Branch saveBranch(BranchDto branchDto) {
		Branch branch = null;
		try {
			branch = branchRepository.save(BranchMapper.convertToBranch(branchDto));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return branch;
	}
	
	public List<BranchDto> getBranches() {
		List<BranchDto> branchDtos = new ArrayList<>();
		List<Branch> branches = branchRepository.findAll();
		
		if(CollectionUtils.isNotEmpty(branches)) {
			branchDtos = branches.stream()
										.filter(Objects::nonNull)
										.map(branch ->  BranchMapper.convertToBranchDto(branch))
										.filter(Objects::nonNull)
										.collect(Collectors.toList());
		}
		return branchDtos;
	}
	
	public BranchDto getBranchByCode(final String branchCode) {
		BranchDto branchDto = null;
		if(StringUtils.isNotEmpty(branchCode)) {
			Branch branch = branchRepository.findByBranchCode(branchCode);
			branchDto = BranchMapper.convertToBranchDto(branch);
		}
		return branchDto;
	}

}
