package com.epam.director.associativeclasses;

import java.util.regex.Pattern;

public class ConeValidator {
	
	/*ver 1.0, fix it*/
	private static final String VALIDATION_REGEX = "(\\d+\\s){4}\\d+";
	private static final String DELIMITER = " ";
	
	public ConeValidator() {
		
	}
	
	public boolean isValid(String inputData) {
		boolean resultOfValidation = true;
		if (Pattern.matches(VALIDATION_REGEX, inputData)) {
			resultOfValidation = secondValidation(inputData);
		} else {
			resultOfValidation = false;
		}
		return resultOfValidation;
	}
	
	private static boolean secondValidation(String inputData) {
		String[] srtingTypeParameters = inputData.split(DELIMITER);
		Integer[] integerTypeParameters = new Integer[srtingTypeParameters.length];
		for (int i = 0; i < integerTypeParameters.length; i++) {
			integerTypeParameters[i] = Integer.parseInt(srtingTypeParameters[i]);
		}
		/*Radius or Height of the cone cannot be zero*/
		if (integerTypeParameters[4] <= 0 || integerTypeParameters[3] <= 0 ) {
			return false;
		} else {
			return true;
		}
	}
}
