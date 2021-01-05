public class AllTested {
	protected static AllTested [] testedPeople = new AllTested[100]; //array that includes everyone tested for covid-19
	private static int count;  //variable that counts created objects
	private String name;        //tested patient's name
	private String surname;	  //tested patient's surname
	private int age;          //tested patient's age
	private int tested;           //test's result
  
	public AllTested(String name, String surname, int age, int tested) {
		testedPeople[count] = this;             //add object to the array
		count++;                                //increase the number of created objects
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.tested = tested;
	}
   

	@Override
	public String toString() {
		return "AllTested [name=" + name + ", surname=" + surname + ", age=" + age + ", tested=" + tested + "]";
	}



	public String getName(){
		return name;
	}
  
	public void setName(String nameValue){
		name = nameValue;
	}
    
	public static void printTested() {
		for(int i=0;i<testedPeople.length; i++){                //search the testedPeople array
			if (testedPeople[i] != null) {                         //if someone tested exists in the specific position [i]
				System.out.println (testedPeople[i]);
			}
		}
	}
}

