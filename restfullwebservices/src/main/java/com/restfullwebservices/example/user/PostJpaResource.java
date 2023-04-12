package com.restfullwebservices.example.user;

import java.util.List;
import java.util.Optional;

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
import com.restfullwebservices.example.repository.PostRepository;
import com.restfullwebservices.example.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class PostJpaResource {
	
	private PostRepository repository;

	public PostJpaResource(PostRepository repository) {
		this.repository= repository;
	}
	
	@GetMapping("/jpa/post")
	public List<Post> retrieveAllUsers(){
		return repository.findAll();
	}
	
	//http://localhost:8080/users
	//EntityModel
	//WebMvcLinkBuilder
	
	@GetMapping("/jpa/post/{id}")
	public EntityModel<Post> retrievePost(@PathVariable int id){
		Optional<Post> post = repository.findById(id);
		if(post==null)
			throw new UserNotFoundException("id:"+id);
		EntityModel<Post> entityModel = EntityModel.of(post.get());		
		return entityModel;
	}
	
	@PostMapping("/jpa/post")
	public ResponseEntity<Post> createPost(@Valid @RequestBody Post post){
		repository.save(post);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/jpa/post/{id}")
	public void deletePost(@PathVariable int id){
		repository.deleteById(id);
	}
}
