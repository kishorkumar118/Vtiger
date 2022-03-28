package com.crm.autodesk.genericutility;
import java.util.Date;
import java.util.Random;
   /**
	 * 
	 * @author Kishorkumar
	 *
	 */

	public class JavaUtility{
		
		/**
		 * It is used to generate random number
		 * @return int data
		 */
		public int getRandomnumber()
		{
			Random random= new Random();
			int intrandom = random.nextInt(1000);
			return intrandom;
			
		}
		/**
		 * used to get system date and time in IST format
		 * @return
		 */
		public String getSystemDateandTime()
		{
			Date date = new Date();
			return date.toString();
		}
		/**
		 * used to get system date YYYY-MM-DD format
		 * @return
		 */
		public String getSystemDatewithFormate()
		{
			Date date = new Date();
			String dateandtime = date.toString();
			String YYYY =dateandtime.split(" ")[5];
			String DD =dateandtime.split(" ")[2];
			int MM =date.getMonth()+1;
			String finalformate = YYYY +"_"+DD+"_"+MM;
			return finalformate;
		}
	}
	
