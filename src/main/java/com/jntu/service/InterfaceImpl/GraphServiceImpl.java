package com.jntu.service.InterfaceImpl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jntu.random.interfaces.RandomNumberGeneratorInterface;
import com.jntu.service.Interface.GraphServiceInterface;

@Service
public class GraphServiceImpl implements GraphServiceInterface {

	// The randomNumberGenerator which is used to generate randomNumbers
	@Autowired
	RandomNumberGeneratorInterface generator;

	// Logger is used to generate logs in the console for debugging purposes
	private static Logger log = Logger.getLogger(GraphServiceImpl.class.getName());
		
	@Override
	public Map<String, String> getResponse(Map<String, Object> requestParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> processBasicGraphRequest(Map<String, Object> requestParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> processNPartiteGraphRequest(Map<String, Object> requestParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> processCompleteGraphRequest(Map<String, Object> requestParams) {
		// TODO Auto-generated method stub
		return null;
	}

}
