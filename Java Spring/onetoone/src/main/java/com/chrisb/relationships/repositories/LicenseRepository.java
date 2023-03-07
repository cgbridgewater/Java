package com.chrisb.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

	@Override
	List<License> findAll();
}
