package com.currencyfair.Validator;

public class Validator {
	
	/**
	 * 	Method checks if a string contains only alphabets
	 * @param value
	 * @return boolean 
	 */
	public static boolean validateString(String value){
		boolean valid = false;		
	
		if(value !=null && !"".equals(value)){
			valid = true;
		}
		return valid; //method has only one return statement
	}	
	
	public static boolean validatePostiveInt(int value){
		boolean valid = false;		
		
		if(value > 0){
			valid = true;
		}
		return valid; //method has only one return statement
	}
	
	public static boolean validateFloatPositve(float value){
		boolean valid = false;		
		
		if(value > 0.0f){
			valid = true;
		}
		return valid; //method has only one return statement
	}
}