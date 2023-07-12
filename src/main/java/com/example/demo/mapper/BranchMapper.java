package com.example.demo.mapper;

import java.util.Objects;

import com.example.demo.dao.Branch;
import com.example.demo.dto.BranchDto;

public class BranchMapper {
	
	public static Branch convertToBranch(final BranchDto branchDto) {
		Branch branch = null;
		if(Objects.nonNull(branchDto)) {
			branch = new Branch();
			branch.setBranchName(branchDto.getBranchName());
			branch.setBranchDescription(branchDto.getBranchDescription());
			branch.setBranchCode(branchDto.getBranchCode());
			branch.setAddress(AddressMapper.convertToAddress(branchDto.getAddress()));
		}
		return branch;
	}

	public static BranchDto convertToBranchDto(final Branch branch) {
		BranchDto branchDto = null;
		if(Objects.nonNull(branch)) {
			branchDto = new BranchDto();
			branchDto.setId(branch.getId());
			branchDto.setBranchName(branch.getBranchName());
			branchDto.setBranchDescription(branch.getBranchDescription());
			branchDto.setBranchCode(branch.getBranchCode());
			branchDto.setAddress(AddressMapper.convertToAddressDto(branch.getAddress()));
		}
		return branchDto;
	}

}
