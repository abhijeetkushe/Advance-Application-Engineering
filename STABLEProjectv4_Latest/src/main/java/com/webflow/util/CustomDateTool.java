package com.webflow.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateTool implements Serializable {

	public String format(String pattern,Date date)
	{
		if(date!=null)
		{	
			SimpleDateFormat sdf=new SimpleDateFormat(pattern);
			return sdf.format(date);
		}
		else{
			return "";
		}
	}
	
	public static Date parseDate(String pattern,String date){
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Date parseLong(long dateTime){
		return new Date(dateTime);
	}
	
}
