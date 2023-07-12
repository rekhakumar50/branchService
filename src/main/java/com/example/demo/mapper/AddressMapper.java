package com.example.demo.mapper;

import java.util.Objects;

import com.example.demo.dao.Address;
import com.example.demo.dto.AddressDto;

public class AddressMapper {
	
	public static Address convertToAddress(final AddressDto addressDto) {
		Address address = null;
		if(Objects.nonNull(addressDto)) {
			address = new Address();
			address.setAddressLine1(addressDto.getAddressLine1());
			address.setAddressLine2(addressDto.getAddressLine2());
			address.setCity(addressDto.getCity());
			address.setState(addressDto.getState());
			address.setCountry(addressDto.getCountry());
			address.setPincode(addressDto.getPincode());
		}
		
		return address;
	}
	
	
	public static AddressDto convertToAddressDto(final Address address) {
		AddressDto addressDto = null;
		if(Objects.nonNull(address)) {
			addressDto = new AddressDto();
			addressDto.setAddressLine1(address.getAddressLine1());
			addressDto.setAddressLine2(address.getAddressLine2());
			addressDto.setCity(address.getCity());
			addressDto.setState(address.getState());
			addressDto.setCountry(address.getCountry());
			addressDto.setPincode(address.getPincode());
		}
		
		return addressDto;
	}

}
