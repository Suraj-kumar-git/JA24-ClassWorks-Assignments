package java8.datefeature;

import java.time.LocalDate;

public class DateAPI {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1.isLeapYear());
		
		LocalDate date2 = LocalDate.of(2023, 12, 31);
		System.out.println(date1.isAfter(date2)); //True
		System.out.println(date1.isBefore(date2)); //False
		System.out.println("Tomorrow's Date: "+date1.plusDays(1));
		System.out.println("Next Month Date: "+date1.plusMonths(1));
		System.out.println("Next Year Date: "+date1.plusYears(1));
		System.out.println("Previous Year Date: "+date1.minusYears(1));
		System.out.println("Today's date in 2010: "+date1.withYear(2010));
		
		System.out.println("Day of Month: "+date1.getDayOfMonth());
		System.out.println("Year: "+date1.getYear());
		System.out.println("Month: "+date1.getMonth());
		System.out.println("Day of year: "+date1.getDayOfYear());
	}

}
