package com.restfullwebservices.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullwebservices.example.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
