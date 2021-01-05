public class Negative {
	protected static Negative [] negativePatients = new Negative[100]; //array that includes everyone tested negative for covid-19
	protected static int [] negativeTestsDone = new int [100];//array to count tests done to every negative patient
	private static int count;  //variable that counts created objects
	private String name;        //negative patient's name
	private String surname;	  //negative patient's surname
	private int age;          //negative patient's age
	private int tested;           //test's result
  
	public Negative(String name, String surname, int age, int tested) {
		negativePatients[count] = this;             //add object to the array
		negativeTestsDone[count]=1;                //add object to the array
		count++;                                //increase the number of created objects
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.tested = tested;
	}
   

	@Override
	public String toString() {
		return "Positive [name=" + name + ", surname=" + surname + ", age=" + age + ", tested=" + tested + "]";
	}



	public String getName(){
		return name;
	}
  
	public void setName(String nameValue){
		name = nameValue;
	}
    
	public static void printNegative() {
		for(int i = 0; i < negativePatients.length; i++){                //search the negativePatients array
			if (negativePatients[i] != null) {                         //if someone tested exists in the specific position [i]
				System.out.println (negativePatients[i]);
			}
		}
	}
}
