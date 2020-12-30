package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Arrays;

public class RepeatTest {

	// the methods print all the negative and positive patients that need to be
	// tested today
	public static int placePositive(Positive[] p, String name) {
		int tableplace = -1;
		for (int i = 0; i <= p.length; i++) {
			if (p[i].getName() == name) {
				tableplace = i;
			}
		}
		return tableplace;
	}

	public static int placeNegative(Negative[] p, String name) {
		int tableplace = -1;
		for (int i = 0; i <= p.length; i++) {
			if (p[i].getName() == name) {
				tableplace = i;
			}
		}
		return tableplace;
	}

	public static Positive[] removePositive(Positive[] p, int tableplace) {
		List<Positive> list = Arrays.asList(p);
		for (Positive item : p)
			if (item.getID() == tableplace)
				list.remove(item);
		return list.toArray(p);
	}

	public static Negative[] removeNegative(Negative[] p, int tableplace) {
		List<Negative> list = Arrays.asList(p);
		for (Negative item : p)
			if (item.getID() == tableplace)
				list.remove(item);
		return list.toArray(p);
	}

	public static void RepeatPositive() {
		Scanner sc = new Scanner(System.in);
		Date date = new Date(System.currentTimeMillis()); // today's date
		System.out.println("Positive patients that need to repeat test: ");
		for (int i = 0; i < Positive.positivePatients.length; i++) {
			if (Positive.positivePatients[i] != null) {
				// difference between today's date and the day of the test
				Date date2 = Positive.positivePatients[i].getDot(); // date of test
				long diff = TimeUnit.DAYS.convert(date.getTime() - date2.getTime(), TimeUnit.MILLISECONDS);
				if ((diff == 15) && (Positive.positiveTestsDone[i] == 1)) {
					System.out.println("Do the test again and insert the result.");
					int choice = sc.nextInt();
					TestResultResponse.testResultResponse(choice);
					if (choice == 1) { // is negative
						// διαγραφή και πέρασμα στους negative
						System.out.println("Please insert patient's name");
						String name = sc.next();
						int tableplace = placePositive(Positive.positivePatients, name);

						if (tableplace == -1) {
							System.out.println("There is no patient with such name");
						} else {
							Negative negativePatients = new Negative(name);
							removePositive(Positive.positivePatients, tableplace);
						}
						System.out.println("Test has been inserted successfully.");
						Positive.positiveTestsDone[i] = 2;
					} else if (choice == 2) { // is positive
						// διαγραφή και ξαναδημιουργία αντικειμένου με καινουριο date of test
						System.out.println("Please insert patient's name");
						String name = sc.next();
						int tableplace = placePositive(Positive.positivePatients, name);
						Date date3 = new Date(System.currentTimeMillis());
						Positive.positivePatients[tableplace].setDot(date3);
						System.out.println("Test has been inserted successfully.");
						Positive.positiveTestsDone[i] = 2;
					}
				}
			}
		}
	}

	public static void RepeatNegative() {
		Scanner sc = new Scanner(System.in);
		Date date = new Date(System.currentTimeMillis()); // today's date
		System.out.println("Positive patients that need to repeat test: ");
		for (int i = 0; i < Positive.positivePatients.length; i++) {
			if (Positive.positivePatients[i] != null) {
				// difference between today's date and the day of the test
				Date date2 = Positive.positivePatients[i].getDot(); // date of test
				long diff = TimeUnit.DAYS.convert(date.getTime() - date2.getTime(), TimeUnit.MILLISECONDS);
				if ((diff == 15) && (Positive.positiveTestsDone[i] == 1)) {
					System.out.println("Do the test again and insert the result.");
					int choice = sc.nextInt();
					TestResultResponse.testResultResponse(choice);
					if (choice == 1) { // is negative again
						//ολική διαγραφή απο negative
						System.out.println("Please insert your name again");
						String name = sc.next();
						int tableplace = placeNegative(Negative.negativePatients, name);
						if (tableplace == -1) {
							System.out.println("There is no patient with such name");
						} else {
							Positive positivePatients = new Positive(name);
							removeNegative(Negative.negativePatients, tableplace);
						}
						System.out.println("Test has been deleted successfully.");
					} else if (choice == 2) { // is positive
						// διαγραφή από negative και περασμα στους positive
						System.out.println("Please insert your name again");
						String name = sc.next();
						int tableplace = placeNegative(Negative.negativePatients, name);
						if (tableplace == -1) {
							System.out.println("There is no patient with such name");
						} else {
							Positive positivePatients = new Positive(name);
							removeNegative(Negative.negativePatients, tableplace);
						}
					}
					System.out.println("Test has been inserted successfully.");
					Negative.negativeTestsDone[i] = 2;
				}
			}
		}
	}

	// Function to add x in arr
	public static int[] addX(int n, int arr[], int x) {
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
