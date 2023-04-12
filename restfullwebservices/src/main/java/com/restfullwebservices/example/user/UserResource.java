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

import jakarta.persistence.Table;
import jakarta.validation.Valid;

@RestController
@RequestMapping
//@Table(name="users-details")
public class UserResource {
	
	@Autowired
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
//	@PostMapping
//	public User save(@RequestBody User user) {
//		return service.save(user);
//	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//http://localhost:8080/users
	//EntityModel
	//WebMvcLinkBuilder
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id){
		User user = service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		EntityModel<User> entityModel = EntityModel.of(user);
		
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		service.save(user);
		return ResponseEntity.created(null).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
	}
	
}
