package com.thbs.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordPattern
{
	public static boolean match(String line){
		/*
    	^                 # start-of-string
		(?=.*[0-9])       # a digit must occur at least once
		(?=.*[a-z])       # a lower case letter must occur at least once
		(?=.*[A-Z])       # an upper case letter must occur at least once
		(?=.*[@#$%^&+=])  # a special character must occur at least once
		(?=\S+$)          # no whitespace allowed in the entire string
		.{8,}             # anything, at least eight places though
		$                 # end-of-string 
		*/




		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%_^&+=])(?=\\S+$).{6,}$";

		Pattern r = Pattern.compile(pattern);

		Matcher m = r.matcher(line);
		if (m.find( )) {
			return true;
		} else {
			return false;
		}
	}
}