package com.epam.director.associativeclasses;

import java.util.regex.Pattern;

public class ConeValidator {
	
	/*ver 1.0, fix it*/
	private static final String VALIDATION_REGEX = "(\\d+\\s){4}\\d+";
	
	public ConeValidator() {
		
	}
	
	public boolean isValid(String inputData) {
		return Pattern.matches(VALIDATION_REGEX, inputData);
	}
}
