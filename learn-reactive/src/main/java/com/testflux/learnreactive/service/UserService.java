package com.testflux.learnreactive.service;

import com.testflux.learnreactive.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface UserService {

	public Flux<User> findAll();
	public Mono<User> findById(String id);
	public Mono<User> save(User user);
	public Mono<User> delete(String id);
}
