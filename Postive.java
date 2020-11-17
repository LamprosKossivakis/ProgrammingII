package com.company;

import java.util.Date;

public class Postive {
    protected static Postive [] positivePatients = new Postive[100];//array to store the positivePatients
    private static int count;                              //count created objects
    private int id;                                        //positivePatient's id
    private String name;                                   //positivePatient's name
    private Date dob;                                      //positivePatient's birthday yyyy/MM/dd

    public Postive(String name, Date dob) {
        positivePatients[count]=this;              //add object to the array
        count++;                                   //increase the number of created students
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

    public static void printStudents() {
        for(int i=0;i<positivePatients.length; i++){                //search the positivePatients array
            if (positivePatients[i]!=null){                         //if a patients exists in the specific position [i]
                System.out.println (positivePatients[i]);
            }
        }
    }

}
