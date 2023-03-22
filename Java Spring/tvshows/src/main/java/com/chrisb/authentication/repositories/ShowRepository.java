package com.chrisb.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Show;
import com.chrisb.authentication.models.User;

@Repository
public interface ShowRepository  extends CrudRepository<Show, Long>  {

	@Override
	List<Show> findAll();
	
	public Optional<Show> findByTitle(String title);
	


	List<Show> findAllByShows(User c);
	List<Show> findAllByShowsIsNot(User c);
	
	
//	List<Show> findAllByShows(User user);
	List<Show> findByShowsNotContains(User user);


	
	
	
	
//	List<Show> findAllByShowCreator(User c);
//	List<Show> findAllByShowCreatorIsNot(User c);

	
}
