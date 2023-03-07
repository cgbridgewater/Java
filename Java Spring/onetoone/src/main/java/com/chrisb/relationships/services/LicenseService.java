package com.chrisb.relationships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chrisb.relationships.models.License;
import com.chrisb.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {

	
	@Autowired
	private LicenseRepository licenseRepo;
	
	
	// create a license
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
	
	
}
