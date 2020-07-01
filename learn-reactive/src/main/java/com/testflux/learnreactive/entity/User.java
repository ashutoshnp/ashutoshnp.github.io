package com.testflux.learnreactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document
@Data
@AllArgsConstructor
public class User {
	
	@Id
	private String id;
	private String name;
	private String email;

}
