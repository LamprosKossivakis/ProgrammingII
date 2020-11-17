import java.util.Date;

public class Negative {
	protected static Negative [] negativePatients = new Negative[100];//array to store the negative patients
	private static int count;                              //count created objects
    private int id;                                        //negative patient's id
    private String name;                                   //negative patient's name
    private Date dob;                                      //negative patient's birthday yyyy/MM/dd

    public Negative(String name, Date dob) {
        negativePatients[count]=this;              //add object to the array
        count++;                                   //increase the number of created students
        id=count;                                  //assign the current value of the static variable count to the id
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Negative patient's  name = " + name +" ,Date of birth " + dob + " and id [" + id +" ]";
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
        for(int i=0;i<negativePatients.length; i++){                //search the negative patients' array
            if (negativePatients[i]!=null){                         //if a negative patient exists in the specific position [i]
                System.out.println (negativePatients[i]);
            }
        }
    }

}

