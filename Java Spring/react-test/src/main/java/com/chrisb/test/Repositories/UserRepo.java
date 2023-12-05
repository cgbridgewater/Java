package com.chrisb.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chrisb.test.Models.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
