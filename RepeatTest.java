package com.company;
import java.util.*;
import java.io.*; 
import java.lang.*;
import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;
//import org.apache.commons.lang3.ArrayUtils;

public class RepeatTest {

	// the methods print all the negative and positive patients that need to be tested today
	// we can transfer them to Positive and Negative  
	public static int place(Positive[] p, String name) {
		int tableplace = -1;
		for (int i=0;i<=p.length;i++) {
			if (p[i].getName()== name) {
				tableplace = i;
			} 
			}
		return tableplace;
			}
		

	
	
	
	
	public static void RepeatPositive() {
		//today's date
		Date date = new Date(System.currentTimeMillis());

		System.out.println("Positive patients that need to repeat test: ");
		for (int i=0;i<Positive.positivePatients.length; i++) {
			if (Positive.positivePatients[i]!=null) {
				//difference between today's date and the day of the test
				long diff1 = (date.getTime()-Positive.positivePatients[i].getDate());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
				if ((diff = 15) && (Positive.positiveTestsDone[i]==1)){
					System.out.println("Do the test again. If it is Positive, type 1, if it's negative, type 2");
					
					 Scanner sc = new Scanner(System.in);
					int choice = sc.nextInt();
					if (choice==1) {
						System.out.println("You don't have to be tested again");
					} else {
						System.out.println("Please insert your name again");
						String name=sc.next();
						int tableplace = place(Positive.positivePatients,name);
						
						if (tableplace == -1) {
							System.out.println("There is no patient with such name");
						} else {
							//array_new = ArrayUtils.removeElement(array, element)
							//Positive positivePatients = ArrayUtils.remove(Positive.positivePatients,tableplace);
							Negative negativePatients = new Negative(name);
							
							
							positivePatients_new=ArrayUtils.removeElement(Positive.positivePatients,tableplace);
							
							
						}
						
						
					}
					System.out.println (Positive.positivePatients[i]);
					Positive.positiveTestsDone[i]=2;
				}
			}
		}
	}

	public static void RepeatNegative() {
		//today's date
		Date date = new Date(System.currentTimeMillis()); 
		System.out.println("Negative patients that need to repeat test: ");
		for (int i=0;i<Negative.negativePatients.length; i++) {
			if (Negative.negativePatients[i]!=null) {
				//difference between today's date and the day of the test
				long diff1 = (date.getTime()-Negative.negativePatients[i];	//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS); 
				if ((diff = 3) && (Negative.negativeTestsDone[i]==1)) {
					System.out.println("Do the test again. If it is Positive, type 1, if it's negative, type 2");
					
					 Scanner sc = new Scanner(System.in);
					int choice = sc.nextInt();
					if (choice==2) {
						System.out.println("You have to wait again");
					} else {
						System.out.println("Please insert your name again");
						String name=sc.next();
						int tableplace = place(Negative.negativePatients,name);
						
						if (tableplace == -1) {
							System.out.println("There is no patient with such name");
						} else {
							//array_new = ArrayUtils.removeElement(array, element)
							//Positive positivePatients = ArrayUtils.remove(Positive.positivePatients,tableplace);
							
							Positive positivePatients = new Positive(name);
							
							
							NegativePatients_new=ArrayUtils.removeElement(Negative.negativePatients,tableplace);
							
							
						}
						
						
					}
					
					
					System.out.println (Negative.negativePatients[i]);
					Negative.negativeTestsDone[i]=2;
					//Negative newnegativepatients = add(negativepatients, "Dean");
				}
			}
		}
	}
	
		  
	    // Function to add x in arr 
	    public static int[] addX(int n, int arr[], int x)  { 
	        int i; 
	  
	        // create a new array of size n+1 
	        int newarr[] = new int[n + 1]; 
	  
	        // insert the elements from 
	        // the old array into the new array 
	        // insert all elements till n 
	        // then insert x at n+1 
	        for (i = 0; i < n; i++) 
	            newarr[i] = arr[i]; 
	  
	        newarr[n] = x; 
	  
	        return newarr; 
	    } 
}
