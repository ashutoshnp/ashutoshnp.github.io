package com.testflux.learnreactive.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.testflux.learnreactive.entity.User;

public interface UserRepository extends ReactiveMongoRepository<User, String>{

}
