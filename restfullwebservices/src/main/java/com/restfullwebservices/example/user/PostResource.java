package com.restfullwebservices.example.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfullwebservices.example.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class PostResource {
	@Autowired
	private PostDaoService service;

	public PostResource(PostDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/post")
	public List<Post> retrieveAllPosts(){
		return service.findAll();
	}
	
	//http://localhost:8080/users
	//EntityModel
	//WebMvcLinkBuilder
	
	@GetMapping("/post/{id}")
	public EntityModel<Post> retrievePost(@PathVariable int id){
		Post post = service.findOne(id);
		if(post==null)
			throw new UserNotFoundException("id:"+id);
		EntityModel<Post> entityModel = EntityModel.of(post);
		
		return entityModel;
	}
	
	@PostMapping("/post")
	public ResponseEntity<Post> createPost(@Valid @RequestBody Post post){
		service.save(post);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/post/{id}")
	public void deletePost(@PathVariable int id){
		service.deleteById(id);
	}
}
