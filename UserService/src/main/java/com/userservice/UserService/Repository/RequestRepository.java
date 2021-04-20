package com.userservice.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.UserService.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{



}
