package com.crm.autodeskgenericutility;


import java.util.Date;
import java.util.Random;
/**
 * 
 * @author jayapradha
 *
 */

public class JavaUtility {
	/**
	 * this method is used to generate random numbers
	 * @return int data
	 */
	

	public int GetRandom()
	
	{
		Random rn=new Random();
		int random=rn.nextInt(1000);
		return random;
		
	}
	/**
	 * used to generate system date and time in IST format
	 * @return String  date
	 */
	
	public String getSystemDateAndTime()
	{
Date date=new Date();
		return date.toString().replace(":", "-");
	}
	/**
	 * used to generate system date and time in YYYY-MM-DD format
	 * 
	 * @return String Fileformat
	 */
	public String getsystemDateWithFormat()
	{
		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM=date.getMonth()+1;
		String fileformat=yyyy+"-"+MM+"-"+DD;
		return fileformat;
		
	}

}
