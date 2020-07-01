package com.testflux.learnreactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testflux.learnreactive.entity.User;
import com.testflux.learnreactive.repo.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private final UserRepository userRepository;

	@Override
	public Flux<User> findAll() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public Mono<User> findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Mono<User> save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Mono<User> delete(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id)
				.flatMap(user -> userRepository.deleteById(user.getId()).thenReturn(user));
	}
	
	
}
