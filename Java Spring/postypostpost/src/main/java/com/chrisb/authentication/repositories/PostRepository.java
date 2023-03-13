package com.chrisb.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chrisb.authentication.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {

	public List<Post> findAll();
	
//	@Query(value = "SELECT * FROM post WHERE post.user_id != %?1%", nativeQuery = true)
//	public List<Post> fiindAllNotByUser(Long userId);
	
}
