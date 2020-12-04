package com.company;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RepeatTest {

	// the methods print all the negative and positive patients that need to be tested today
	// we can transfer them to Positive and Negative  
	
	public static void RepeatPositive() {
		//today's date
		Date date = new Date(System.currentTimeMillis()); 
		System.out.println("Positive patients that need to repeat test: ");
		for (int i=0;i<positivePatients.length; i++) {
			if (positivePatients[i]!=null) {
				//difference between today's date and the day of the test
				long diff1 = (date.getTime()-positivePatients[i].//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
				if (diff = 15) && (postiveTestsDone==1){
					System.out.println (positivePatients[i]);
					positiveTestsDone[i]=2;
				}
			}
		}
	}

	public static void RepeatNegative() {
		//today's date
		Date date = new Date(System.currentTimeMillis()); 
		System.out.println("Negative patients that need to repeat test: ");
		for (int i=0;i<negativePatients.length; i++) {
			if (negativePatients[i]!=null) {
				//difference between today's date and the day of the test
				long diff1 = (date.getTime()-negativePatients[i].//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS); 
				if (diff = 3) && (negativeTestsDone==1) {
					System.out.println (negativePatients[i]);
					negativeTestsDone[i]=2;
				}
			}
		}
	}
}
