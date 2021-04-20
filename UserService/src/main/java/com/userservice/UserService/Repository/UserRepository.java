package com.userservice.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.UserService.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

 

}
