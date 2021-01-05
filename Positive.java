public class Positive {
	protected static Positive [] positivePatients = new Positive[100]; //array that includes everyone tested postive for covid-19
	protected static int [] positiveTestsDone = new int [100];//array to count tests done to every positive patient
	private static int count;  //variable that counts created objects
	private String name;        //positive patient's name
	private String surname;	  //positive patient's surname
	private int age;          //positive patient's age
	private int tested;           //test's result
  
	public Positive(String name, String surname, int age, int tested) {
		positivePatients[count] = this;             //add object to the array
		positiveTestsDone[count]=1;                //add object to the array
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
    
	public static void printPositive() {
		for(int i = 0; i < positivePatients.length; i++){                //search the positivePatients array
			if (positivePatients[i] != null) {                         //if someone tested exists in the specific position [i]
				System.out.println (positivePatients[i]);
			}
		}
	}
}

