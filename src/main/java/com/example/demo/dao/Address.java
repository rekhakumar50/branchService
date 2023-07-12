package com.example.demo.dao;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String pincode;

}
