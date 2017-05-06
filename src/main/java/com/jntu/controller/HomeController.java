package com.jntu.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jntu.model.ArrayOfCharacters;
import com.jntu.model.ArrayOfNumbers;
import com.jntu.model.ArrayOfStrings;
import com.jntu.model.MatrixOfCharacters;
import com.jntu.model.MatrixOfNumbers;
import com.jntu.model.PathMatrix;

// This controller is used to serve jsp pages of our application

@Controller
public class HomeController {

	// This method returns the home page of our application
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePageController() {
		return "home";
	}
	
	// This method returns the Test case Generator main functionality page
		@RequestMapping(value = "/testcasegenerator", method = RequestMethod.GET)
		public String testcaseGeneratorPageController() {
			return "TestcaseGenerator";
		}

	// This method returns the basic-data-type form page
	@RequestMapping(value = "/testcasegenerator/datatypes", method = RequestMethod.GET)
	public String basicDataTypePageController() {
		return "datatypes";
	}

	// This method returns the array form page
	@RequestMapping(value = "/arrays", method = RequestMethod.GET)
	public String viewArraysPage(Map<String, Object> model) {
		model.put("arrayOfNumbersForm", new ArrayOfNumbers());
		model.put("arrayOfCharactersForm", new ArrayOfCharacters());
		model.put("arrayOfStringsForm", new ArrayOfStrings());
		return "Arrays";
	}

	// This method returns the matrix form page
	@RequestMapping(value = "/testcasegenerator/matrix", method = RequestMethod.GET)
	public String viewMatrixPage(Map<String, Object> model) {
		model.put("matrixOfNumbersForm", new MatrixOfNumbers());
		model.put("matrixOfCharactersForm", new MatrixOfCharacters());
		return "matrix";
	}

	// This method returns the tree form page
	@RequestMapping(value = "/testcasegenerator/trees", method = RequestMethod.GET)
	public String treePageController() {
		return "trees";
	}

	// This method returns the graph form page
	@RequestMapping(value = "/testcasegenerator/graphs", method = RequestMethod.GET)
	public String graphPageController() {
		return "graphs";
	}

	// This method returns the miscellaneous form page
	@RequestMapping(value = "/testcasegenerator/miscellaneous", method = RequestMethod.GET)
	public String miscPageController() {
		return "misc";
	}

}
