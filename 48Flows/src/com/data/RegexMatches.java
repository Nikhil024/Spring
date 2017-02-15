package com.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    public static boolean match(String line){

      String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

      Pattern r = Pattern.compile(pattern);

      Matcher m = r.matcher(line);
      if (m.find( )) {
         return true;
      } else {
         return false;
      }
   }
}