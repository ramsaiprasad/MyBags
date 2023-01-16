package com.example.Exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.format.DateTimeFormat;

public class Utilities {
 
    private static final String DATE_FORMAT_REGEX="([0-9]{4})-([0-9]{2})-([0-9]{2})";
    
    public static boolean isNullOrEmptyString(String value)
    {
        return (value==null || value.trim().length()==0);
    }

    public static boolean validateDateFormat(String date)
    {
        Pattern pattern=Pattern.compile(DATE_FORMAT_REGEX);
        Matcher matcher=pattern.matcher(date);
        return matcher.matches();
    }
    
    
}
