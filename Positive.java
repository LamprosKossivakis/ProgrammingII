package com.company;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.SimpleDateFormat;
public class Positive {
    protected static Positive [] positivePatients = new Positive[100];//array to store the positivePatients
    protected static int [] positiveTestsDone = new int [100];//array to count tests done to every positive patient
    private static int count;                              //count created objects
    private int id;                                        //positivePatient's id
    private String name;                                   //positivePatient's name
    private Date dob;                                      //positivePatient's birthday yyyy/MM/dd

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	private String today = formatter.format(date);
    //, Date dob
    public Positive(String name) {
        positivePatients[count]=this;               //add object to the array
        positiveTestsDone[count]=1;                 //add object to the array
        count++;                                   //increase the number of created patients
        id=count;                                  //assign the current value of the static variable count to the id
        this.name = name;
        this.dob = dob;
        this.today =today;
        
    }


    @Override
    public String toString() {
        return "Positive patient's  name = " + name +" ,Date of birth " + dob + " and id [" + id +" ]"+ today;
    }

    public String getToday() {
		return today;
	}


	public void setToday(String today) {
		this.today = today;
	}


	public String getName(){
        return name;
    }
    
    public Date getDateOfBirth() {
        return dob;	
    }
    
    public int getID(){
        return id;
    }


    public void setName(String nameValue){
        name = nameValue;
    }

    public static void printPositive() {
        for(int i=0;i<positivePatients.length; i++){                //search the positivePatients array
            if (positivePatients[i]!=null){                         //if a patients exists in the specific position [i]
                System.out.println (positivePatients[i]);
            }
        }
    }

}
