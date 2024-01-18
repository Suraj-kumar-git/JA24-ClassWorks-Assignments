package java8.datefeature;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeDemos {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);
		
		LocalDate myDate = LocalDate.of(2000, 8, 10);
		System.out.println("My Birthdate: "+myDate);
		
		String str = "2001-04-13";
		LocalDate fromString = LocalDate.parse(str);
		System.out.println("From String: "+fromString);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String str2 = "14-01-2010";
		LocalDate formattedString = LocalDate.parse(str2, formatter);
		System.out.println(formattedString);
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL );
		String formatter2Date2 = date1.format(formatter2);
		System.out.println("Date2 in FULL format: "+formatter2Date2);
		
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
		String myDate1 = date1.format(myFormat);
		System.out.println(myDate1);
		DateTimeFormatter myFormat2 = DateTimeFormatter.ofPattern("dd MM yyyy");
		myDate1 = date1.format(myFormat2);
		System.out.println(myDate1);
		
	}
}
