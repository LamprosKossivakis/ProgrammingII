package com.company;

import java.util.Date;

public class Positive {
    protected static Positive [] positivePatients = new Positive[100];//array to store the positivePatients
    protected static int [] positiveTestsDone = new int [100];//array to count tests done to every positive patient
    private static int count;                              //count created objects
    private int id;                                        //positivePatient's id
    private String name;                                   //positivePatient's name
    private Date dob;                                      //positivePatient's birthday yyyy/MM/dd

    public Positive(String name, Date dob) {
        positivePatients[count]=this;               //add object to the array
        positiveTestsDone[count]=1;                 //add object to the array
        count++;                                   //increase the number of created patients
        id=count;                                  //assign the current value of the static variable count to the id
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Positive patient's  name = " + name +" ,Date of birth " + dob + " and id [" + id +" ]";
    }

    public String getName(){
        return name;
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
