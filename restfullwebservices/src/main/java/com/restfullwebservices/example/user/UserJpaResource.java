package com.restfullwebservices.example.user;

import java.util.List;
import java.util.Optional;

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
import com.restfullwebservices.example.repository.UserRepository;

import jakarta.persistence.Table;
import jakarta.validation.Valid;

@RestController
@RequestMapping
@Table(name="users-details")
public class UserJpaResource {
	
	private UserRepository repository;

	public UserJpaResource(UserRepository repository) {
		this.repository= repository;
	}
	
//	@PostMapping
//	public User save(@RequestBody User user) {
//		return service.save(user);
//	}
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	//http://localhost:8080/users
	//EntityModel
	//WebMvcLinkBuilder
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		EntityModel<User> entityModel = EntityModel.of(user.get());		
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		repository.save(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		repository.deleteById(id);
	}
	
}
