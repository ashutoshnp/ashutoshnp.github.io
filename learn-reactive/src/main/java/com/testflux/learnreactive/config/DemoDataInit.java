package com.testflux.learnreactive.config;

import java.util.UUID;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.testflux.learnreactive.entity.User;
import com.testflux.learnreactive.repo.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;


@Log4j2
@Component
@AllArgsConstructor
@org.springframework.context.annotation.Profile("local")
public class DemoDataInit implements ApplicationListener<ApplicationReadyEvent>{
	
	private final UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		userRepository.deleteAll()
		.thenMany(Flux.just("john","david","jim")
				.map(name -> new User(UUID.randomUUID().toString(),name,name.toLowerCase()+"@mail.com"))
				.flatMap(userRepository::save))
		.thenMany(userRepository.findAll())
		.subscribe(user -> log.info("savingUser"+user));
		// TODO Auto-generated method stub
		
	}

}
