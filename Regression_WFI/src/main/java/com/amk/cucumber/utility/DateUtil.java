package com.amk.cucumber.utility;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public String date() {					
		LocalDate a= LocalDate.now();
		String dd= a.format(DateTimeFormatter.ofPattern("M/d/yy"));
		return dd;
	}
	
	public String dateFormatConversion(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date()); // Using today's date
    	c.add(Calendar.DATE, days); // Adding 5 days
    	String output = sdf.format(c.getTime());
    	return output;
	}
	
	public String dateFormat(int days) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date()); // Using today's date
    	c.add(Calendar.DATE, days); // Adding 5 days
    	String output = sdf.format(c.getTime());
    	return output;
	}
	
	public LocalDate previousMonth() {
		LocalDate previousMonthSameDay = LocalDate.now().minus(3, ChronoUnit.MONTHS);
		return previousMonthSameDay;
	}
	
	public String zoneDateTime(String zon) {				 
        LocalDateTime currentDateTime = LocalDateTime.now();      
        ZoneId pstZone = ZoneId.of(zon);      
        ZonedDateTime pstDateTime = currentDateTime.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(pstZone);        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String formattedDateTime = pstDateTime.format(formatter);

      
       return formattedDateTime;
	}

}
