package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Negative {
	protected static Negative[] negativePatients = new Negative[100];// array to store the enes that tested negative
	protected static int[] negativeTestsDone = new int[100];// array to count tests done to everyone tested negative
	private static int count; // count created objects
	private int id; // negative patient's id
	private String name; // negative patient's name
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String today; // day the patient was tested - String
	// private Date dob; // negative patient's birthday
	private Date dot; // day the patient was tested - Date

	public Negative(String name, String today) {
		negativePatients[count] = this; // add object to the array
		negativeTestsDone[count] = 1; // add object to the array
		count++; // increase the number of created students
		id = count; // assign the current value of the static variable count to the id
		this.name = name;
		this.today = today;
		try {
			this.dot = sdf.parse(today); // day the patient was tested - Date
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Negative patient's  name = " + name + ", id [" + id + " ] and date of test = " + today;
	}

	public Date getDot() {
		return dot;
	}

	public void setDot(Date dot) {
		this.dot = dot;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	/*
	 * public Date getDateOfBirth() { return dob; }
	 */

	public void setName(String nameValue) {
		name = nameValue;
	}

	public static void printNegative() {
		for (int i = 0; i < negativePatients.length; i++) { // search the negative patients' array
			if (negativePatients[i] != null) { // if a negative patient exists in the specific position [i]
				System.out.println(negativePatients[i]);
			}
		}
	}

}
