package com.restfullwebservices.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullwebservices.example.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
