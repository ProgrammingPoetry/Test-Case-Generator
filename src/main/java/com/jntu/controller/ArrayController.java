package com.jntu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jntu.constants.ApplicationConstants;
import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;
import com.jntu.service.Interface.ArrayServiceInterface;

@RestController
@RequestMapping("/arrays")
public class ArrayController {

	@Autowired
	ArrayServiceInterface service;

	@RequestMapping(value = "/numbers", method = RequestMethod.POST)
	public ResponseEntity<?> getArrayOfNumbers(@Valid @ModelAttribute("arrayOfNumbersForm") ArrayOfNumbers input,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				errors.add(error.getDefaultMessage());
			}
			model.put("errors", errors);
			model.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			return ResponseEntity.ok(model);
		}
		Object FileData = null;
		try {
			long startTime = System.currentTimeMillis();
			FileData = service.getFileContent(input);
			long endTime = System.currentTimeMillis();
			long timeTaken = endTime - startTime;
			model.put("timeTaken", String.valueOf(timeTaken) + " ms");
		} catch (Exception e) {
			model.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
		}
		model.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		model.put("data", FileData);
		return ResponseEntity.ok(model);
	}

	@RequestMapping(value = "/characters", method = RequestMethod.POST)
	public ResponseEntity<?> getArrayOfCharacters(
			@Valid @ModelAttribute("arrayOfCharactersForm") ArrayOfCharacters input, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				errors.add(error.getDefaultMessage());
			}
			model.put("errors", errors);
			model.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			return ResponseEntity.ok(model);
		}
		Object FileData = null;
		try {
			long startTime = System.currentTimeMillis();
			FileData = service.getFileContent(input);
			long endTime = System.currentTimeMillis();
			long timeTaken = endTime - startTime;
			model.put("timeTaken", String.valueOf(timeTaken) + " ms");
		} catch (Exception e) {
			model.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
		}
		model.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		model.put("data", FileData);
		return ResponseEntity.ok(model);
	}

	@RequestMapping(value = "/strings", method = RequestMethod.POST)
	public ResponseEntity<?> getArrayOfStrings(@Valid @ModelAttribute("arrayOfStringsForm") ArrayOfStrings input,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError error : allErrors) {
				errors.add(error.getDefaultMessage());
			}
			model.put("errors", errors);
			model.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
			return ResponseEntity.ok(model);
		}
		Object FileData = null;
		try {
			long startTime = System.currentTimeMillis();
			FileData = service.getFileContent(input);
			long endTime = System.currentTimeMillis();
			long timeTaken = endTime - startTime;
			model.put("timeTaken", String.valueOf(timeTaken) + " ms");
		} catch (Exception e) {
			model.put(ApplicationConstants.STATUS, ApplicationConstants.FAILURE_STATUS);
		}
		model.put(ApplicationConstants.STATUS, ApplicationConstants.SUCCESS_STATUS);
		model.put("data", FileData);
		return ResponseEntity.ok(model);
	}

}
