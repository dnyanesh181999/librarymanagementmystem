package com.starlink.librarymanagementmystem.utility;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class AddDaysInCurrentDays {

	public static Date AddDaysCalculator() {
		Date date = new Date();
		Date d1 = DateUtils.addDays(date, 15);
		
		return d1;
	}
	
}
