package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.School;

@Repository
public interface SchoolRepository  extends CrudRepository<School, Long> {

		@Override
		List<School> findAll();
}
