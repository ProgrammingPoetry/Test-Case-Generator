package com.jntu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.random.RandomNumberGenerator;

@Service
public class BasicDataTypeService {

	@Autowired
	RandomNumberGenerator generator;
	
	
	
}
