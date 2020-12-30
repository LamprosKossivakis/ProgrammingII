package com.company;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Positive {
	protected static Positive[] positivePatients = new Positive[100]; // array to store the positivePatients
	protected static int[] positiveTestsDone = new int[100]; // array to count tests done to every positive patient
	private static int count; // count created objects
	private int id; // positivePatient's id
	private String name; // positivePatient's name
	// private Date dob; // positivePatient's birthday yyyy/MM/dd
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String today; // day the patient was tested - String
	private Date dot = new Date(System.currentTimeMillis()); // day the patient was tested - Date

	public Positive(String name) {
		positivePatients[count] = this; // add object to the array
		positiveTestsDone[count] = 1; // add object to the array
		count++; // increase the number of created patients
		id = count; // assign the current value of the static variable count to the id
		this.name = name;
		this.today = sdf.format(dot);
	}

	@Override
	public String toString() {
		return "Positive patient's  name = " + name + ", id [" + id + "] and date of test: " + today;
	}

	public Date getDot() {
		return dot;
	}

	public void setDot(Date dot) {
		this.dot = dot;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getName() {
		return name;
	}

	/*
	 * public Date getDateOfBirth() { return dob; }
	 */

	public int getID() {
		return id;
	}

	public void setName(String nameValue) {
		name = nameValue;
	}

	public static void printPositive() {
		for (int i = 0; i < positivePatients.length; i++) { // search the positivePatients array
			if (positivePatients[i] != null) { // if a patients exists in the specific position [i]
				System.out.println(positivePatients[i]);
			}
		}
	}

}
