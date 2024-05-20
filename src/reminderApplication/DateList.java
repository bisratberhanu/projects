package reminderApplication;

import java.util.ArrayList;
import java.util.Arrays;

//import date.Date;

public class DateList {
	public static  ArrayList <Integer> getYears() 
	{
		int startingYear = 2022;
		int maxYear = 2050;
		ArrayList <Integer>years = new ArrayList<Integer>(maxYear);
		for (int year = startingYear; year <= maxYear; year++)
			years.add(year);
		return years;
	}
	
	// Get list of months: 
	public static  ArrayList<String> getMonths() 
	{
		String[] monthsArray = {"January", "Febuary", "March", "April", "May", "June",
						 "July", "August", "September", "October", "November", "Decmber"};
		ArrayList <String>monthList = new ArrayList<String>(Arrays.asList(monthsArray));
		return monthList;
	}
	
	// Get list of days:
	public static ArrayList<Integer> getValidDays(Date date)
	{
		int maxDay = Date.maxDayOfMonthAndYear(date.getYear(), date.getMonth());
		ArrayList <Integer> validDays = new ArrayList<Integer>(maxDay);
		
		for (int day = 1; day <= maxDay; day++)
			validDays.add(day);
		
		return validDays;
	}
	

}
