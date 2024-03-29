package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Hall;

@Repository
public interface HallRepository  extends CrudRepository<Hall, Long> {

		@Override
		List<Hall> findAll();
}
