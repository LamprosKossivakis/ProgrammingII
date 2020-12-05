import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RepeatTest {

	// the methods print all the negative and positive patients that need to be tested today
	// we can transfer them to Positive and Negative  
	
	public static void RepeatPositive() {
		//today's date
		Date date = new Date(System.currentTimeMillis());

		System.out.println("Positive patients that need to repeat test: ");
		for (int i=0;i<Positive.positivePatients.length; i++) {
			if (Positive.positivePatients[i]!=null) {
				//difference between today's date and the day of the test
				long diff1 = (date.getTime()-Positive.positivePatients[i];   	//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS);
				if ((diff = 15) && (Positive.positiveTestsDone[i]==1)){
					System.out.println (Positive.positivePatients[i]);
					Positive.positiveTestsDone[i]=2;
				}
			}
		}
	}

	public static void RepeatNegative() {
		//today's date
		Date date = new Date(System.currentTimeMillis()); 
		System.out.println("Negative patients that need to repeat test: ");
		for (int i=0;i<Negative.negativePatients.length; i++) {
			if (Negative.negativePatients[i]!=null) {
				//difference between today's date and the day of the test
				long diff1 = (date.getTime()-Negative.negativePatients[i];	//getDate().getTime());
				long diff = TimeUnit.DAYS.convert(diff1, TimeUnit.MILLISECONDS); 
				if ((diff = 3) && (Negative.negativeTestsDone[i]==1)) {
					System.out.println (Negative.negativePatients[i]);
					Negative.negativeTestsDone[i]=2;
				}
			}
		}
	}
}
