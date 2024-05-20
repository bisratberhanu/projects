package reminderApplication;
import java.time.LocalDate;
import java.util.*;
public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date()
	{
		LocalDate date = LocalDate.now();
		this.day = date.getDayOfMonth();
		this.month = date.getMonthValue();
		this.year = date.getYear();
	}

	// Getters: 
	public int getDay() {return day;}
	public int getMonth() {return month;}
	public int getYear() {return year;}

	// Setters: 
	public void setDay(int day) {this.day = day;}
	public void setMonth(int month) {this.month = month;}
	public void setYear(int year) {this.year = year;}
	
	public String toString()
	{
		return (LocalDate.of(getYear(), getMonth(), getDay())).toString();
	}
	
	// Return max valid day according to year and month 
	public static int maxDayOfMonthAndYear(int year, int month)
	{
		switch (month)
		{
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11: 
				return 30;
			case 2:
				if (LocalDate.of(year, 1, 1).isLeapYear())
					return 29;
				else return 28;
			default: return 0; //invalid month
		}
	}
	
	

}
