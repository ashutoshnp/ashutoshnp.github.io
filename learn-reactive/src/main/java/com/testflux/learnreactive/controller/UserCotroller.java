package com.testflux.learnreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.testflux.learnreactive.entity.User;
import com.testflux.learnreactive.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user",produces=MediaType.APPLICATION_JSON_VALUE)
public class UserCotroller {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public Flux<User> findAll()
	{
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<User> findById(@PathVariable (value = "id") String id)
	{
		return userService.findById(id);
	}
	
	@PostMapping
	public Mono<User> createUser(@RequestBody User user)
	{
		return userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public Mono<User> deleteById(@PathVariable String id)
	{
		return userService.delete(id);
	}
	
	@PutMapping
	public Mono<User> updateUser(@RequestBody User user)
	{
		return userService.save(user);
	}
}
